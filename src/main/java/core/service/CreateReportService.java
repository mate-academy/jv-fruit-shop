package core.service;

import core.dao.FruitDao;
import core.dao.FruitDaoImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CreateReportService {
    public void createReport(String fileName) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity\n");
        FruitDao fruitDao = new FruitDaoImpl();
        Map<String,Integer> fruitsMap = fruitDao.getAll();
        for (Map.Entry<String,Integer> entry : fruitsMap.entrySet()) {
            stringBuilder.append(entry.getKey() + "," + entry.getValue() + "\n");
        }
        try {
            Files.write(Path.of(fileName),stringBuilder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }
    }
}
