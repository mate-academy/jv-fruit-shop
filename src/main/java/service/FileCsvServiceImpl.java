package service;

import dao.FruitDaoImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;

public class FileCsvServiceImpl implements FileCsvService {
    private static final String INPUT_FILE_NAME = "src\\main\\java\\resources\\input.csv";
    private static final String OUTPUT_FILE_NAME = "src\\main\\java\\resources\\output.csv";
    private List<String> input;
    private final FruitDaoImpl reportLocalDao = new FruitDaoImpl();

    @Override
    public List<String> getActionsOfDay() {
        try {
            input = Files.readAllLines(Path.of(INPUT_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    @Override
    public void setReport() {
        List<String> report = creatingReport();
        try {
            Files.write(Paths.get(OUTPUT_FILE_NAME), report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> creatingReport() {
        List<Fruit> listOfFruit = reportLocalDao.getListRemainder();
        List<String> listReport = new ArrayList<>();
        listReport.add("fruit,quantity");
        for (Fruit fruit : listOfFruit) {
            listReport.add(fruit.getName() + "," + fruit.getCount());
        }
        return listReport;
    }
}
