package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

public class FileService {
    private static final String TITLE = "fruit,quantity";
    private static final String COMMA = ",";

    public List<String> readDataFromFile(String fileName) {
        File file = new File(fileName);
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
        return dataFromFile;
    }

    public boolean writeReportToFile(Map<Fruit, Integer> fruitStorage, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(TITLE + System.lineSeparator());
            for (Map.Entry<Fruit, Integer> entry : fruitStorage.entrySet()) {
                bufferedWriter.write(entry.getKey().getName() + COMMA
                                        + entry.getValue() + System.lineSeparator());
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file ", e);
        }
    }
}
