package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER_FOR_FILE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public void generateReport(Map<String, Integer> storage, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(HEADER_FOR_FILE);
            writer.newLine();
            for (Map.Entry<String, Integer> entry : storage.entrySet()) {
                writer.write(entry.getKey() + COMMA + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find path: " + filePath, e);
        }
    }
}
