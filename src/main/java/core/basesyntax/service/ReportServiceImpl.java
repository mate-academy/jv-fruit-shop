package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static String FILE_NAME_INPUT = "src/main/resources/listOfFruit.csv";
    private static String FILE_NAME_OUTPUT = "src/main/resources/outputReport.csv";
    private FruitDao fruitDao;
    private ActivityStrategy activityStrategy;

    public ReportServiceImpl(FruitDao fruitDao, ActivityStrategy activityStrategy) {
        this.fruitDao = fruitDao;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void report() {
        // 1 Part: get data from csv file and put data into DB(Storage)
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        List<Fruit> listOfFruit = fruitService.getAllFruitFromFile(FILE_NAME_INPUT);

        // 1.1 Fill DB(Storage) with fruit that contains names only
        Set<String> fruitsNamesOnly = new HashSet<>();
        for (Fruit fruit : listOfFruit) {
            fruitsNamesOnly.add(fruit.getName());
        }

        for (String nameOfFruit : fruitsNamesOnly) {
            Fruit fruit = new Fruit();
            fruit.setName(nameOfFruit);
            fruitDao.add(fruit);
        }

        // 1.2 Fill fruit in DB(Storage) with their amounts that depends on type of operations
        for (Fruit fruit : listOfFruit) {
            if (fruit.getAmount() < 0) {
                throw new RuntimeException("Amount of " + fruit.getName()
                        + " can`t be " + fruit.getAmount() + "There is wrong input amount.");
            }
            int amount = activityStrategy.get(fruit.getType()).getActivity(fruit.getAmount());
            int newAmount = fruitDao.get(fruit.getName()).getAmount() + amount;
            if (newAmount < 0) {
                throw new RuntimeException("Buyers will not be able to buy "
                        + amount + " bananas, because they are only "
                        + fruit.getAmount() + " units in stock.");
            }
            Fruit newFruit = fruitService.createNewFruit(fruit.getName(), newAmount);
            fruitDao.update(newFruit);
        }

        // 2 Part: get data from DB(Storage) and write it into the created new csv file
        try (FileWriter fileWriter = new FileWriter(new File(FILE_NAME_OUTPUT), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("fruit,quantity\n");
            for (Fruit fruit : fruitDao.getAll()) {
                bufferedWriter.write(fruit.getName() + "," + fruit.getAmount() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data into file", e);
        }
    }
}
