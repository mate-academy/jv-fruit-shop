package core.basesyntax.dao;

import static core.basesyntax.model.Storage.storageOfFruits;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvReportWriterImpl implements CsvReportWriter {
    @Override
    public String generateReport(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            StringBuilder builder = new StringBuilder();
            builder.append("fruit,quantity" + System.lineSeparator())
                    .append("banana, " + storageOfFruits.get("banana")
                            + System.lineSeparator())
                    .append("apple, " + storageOfFruits.get("apple"));
            String textInReport = builder.toString();
            writer.write(textInReport);
            return textInReport;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + fileName, e);
        }
    }
}
