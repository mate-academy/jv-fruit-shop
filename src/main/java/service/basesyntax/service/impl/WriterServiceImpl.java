package service.basesyntax.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.basesyntax.service.WriterService;

public class WriterServiceImpl implements WriterService {
    public void write(Map<String, Integer> storage, String pathToWrite) {
        if (pathToWrite == null) {
            throw new NullPointerException("pathToWrite is null");
        }
        if (storage == null) {
            throw new NullPointerException("storage is null");
        }
        try (FileWriter fileWriter = new FileWriter(pathToWrite)) {
            fileWriter.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<String, Integer> entry : storage.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                fileWriter.write(key + "," + value + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing file " + pathToWrite, e);
        }
    }
}
