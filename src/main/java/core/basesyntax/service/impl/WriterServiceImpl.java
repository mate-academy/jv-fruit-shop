package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.WriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    private static final String HEADER = "fruit,quantity";
    @Override
    public void writeDataToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(HEADER);
            for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
                writer.write(System.lineSeparator());
                writer.write(entry.getKey() + ',' + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
