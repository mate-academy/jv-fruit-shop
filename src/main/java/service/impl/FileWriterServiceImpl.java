package service.impl;

import dao.FruitDaoImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String OUTPUT_FILE_NAME = "src\\main\\resources\\output.csv";
    private static final FruitDaoImpl FRUIT_DAO = new FruitDaoImpl();

    @Override
    public boolean write() {
        List<String> report = creatingReport();
        try {
            Files.write(Paths.get(OUTPUT_FILE_NAME), report);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private List<String> creatingReport() {
        List<Fruit> listOfFruit = FRUIT_DAO.getListRemainder();
        List<String> listReport = new ArrayList<>();
        listReport.add("fruit,quantity");
        for (Fruit fruit : listOfFruit) {
            listReport.add(fruit.getName() + "," + fruit.getCount());
        }
        return listReport;
    }
}
