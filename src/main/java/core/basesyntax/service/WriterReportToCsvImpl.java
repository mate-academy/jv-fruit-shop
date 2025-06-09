package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class WriterReportToCsvImpl implements WriterReportToCsv {
    @Override
    public void writeReport(Map<String, BigDecimal> storage, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write("fruit,quantity");
            writer.newLine();
            for (Map.Entry<String, BigDecimal> entry : storage.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + outputFilePath, e);
        }
    }
}
