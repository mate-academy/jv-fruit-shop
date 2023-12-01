package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import model.Fruit;
import model.Transaction;

public class FruitDaoImpl implements FruitDao {
    private static final int FILE_TITLE_INDEX = 0;
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private String filePath;

    public FruitDaoImpl(String filePath, ReportDao reportDao) {
        this.filePath = filePath;
    }

    @Override
    public List<Fruit> getFruit() {
        List<String> fruitList;
        try {
            fruitList = Files.readAllLines(Path.of(filePath));
            fruitList.remove(FILE_TITLE_INDEX);
        } catch (IOException ioException) {
            throw new RuntimeException("Unable to read information from this file "
                    + filePath);
        }
        return fruitList.stream()
                .map(this::getFruitFromFile)
                .collect(Collectors.toList());
    }

    private Fruit getFruitFromFile(String infoFromFile) {
        String[] fileFields = infoFromFile.split(SEPARATOR);
        Fruit fruit = new Fruit();
        fruit.setTransaction(Transaction.getTransactionFromCode(fileFields[TRANSACTION_INDEX]
                .trim()));
        fruit.setFruit(fileFields[FRUIT_INDEX].trim());
        fruit.setQuantity(Integer.parseInt(fileFields[QUANTITY_INDEX].trim()));
        return fruit;
    }
}
