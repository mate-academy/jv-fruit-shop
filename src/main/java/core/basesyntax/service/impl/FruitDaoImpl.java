package core.basesyntax.service.impl;

import core.basesyntax.service.FruitDao;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    //private List<String>  fruits;

    @Override
    public List<String> getInputData(String fileName) {
        File inputDataFile = new File("src/main/resources/" + fileName);
        try {
            inputDataFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: " + inputDataFile, e);
        }
        try {
            return Files.readAllLines(inputDataFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + fileName, e);
        }
    }

    @Override
    public void sendResultData(String report) {
        File resultFile = new File("src/main/resources/result.csv");
        try {
            resultFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: " + resultFile, e);
        }
        try {
            Files.write((resultFile.toPath()), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + resultFile, e);
        }
    }
}
