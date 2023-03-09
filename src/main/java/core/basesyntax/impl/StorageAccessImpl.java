package core.basesyntax.impl;

import core.basesyntax.service.StorageAccess;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class StorageAccessImpl implements StorageAccess {
    private static final String HEADING = "fruit,quantity";

    @Override
    public List<String> readData(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
    }

    @Override
    public void writeData(Map<String, Integer> data, String fileName) {
        try {
            StringBuilder report = new StringBuilder(HEADING);
            for (Map.Entry<String, Integer> pair : data.entrySet()) {
                report.append("\n").append(pair.getKey()).append(',').append(pair.getValue());
            }
            Files.writeString(Path.of(fileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
