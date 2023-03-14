package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteServiceImpl implements WriteService {
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
        final char comma = ',';
        final String fruit = "fruit";
        final String quantity = "quantity";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fruit)
                .append(comma)
                .append(quantity)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(comma)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder;
    }
}
