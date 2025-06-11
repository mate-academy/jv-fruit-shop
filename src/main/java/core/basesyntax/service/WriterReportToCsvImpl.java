package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterReportToCsvImpl implements WriterReportToCsv {
    private static final String TITLE = "fruit,quantity";

    @Override
    public void writeReport(Map<String, Integer> storage, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(TITLE);
            writer.write(System.lineSeparator());
            for (Map.Entry<String, Integer> entry : storage.entrySet()) {
                StringBuilder row = new StringBuilder();
                row.append(entry.getKey())
                        .append(",")
                        .append(entry.getValue());
                writer.write(row.toString());
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + outputFilePath, e);
        }
    }
}
