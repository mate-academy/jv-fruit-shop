package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteServiceImpl implements WriteService {
    private static final char COMMA = ',';
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";

    @Override
    public void writeToFile(Map<String, Integer> storage, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(createReport(storage).toString());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file" + file, e);
        }
    }

    private StringBuilder createReport(Map<String, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FRUIT)
                .append(COMMA)
                .append(QUANTITY)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder;
    }
}
