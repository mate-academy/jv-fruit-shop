package core.basesyntax.dao;

import static core.basesyntax.storage.Storage.storageOfFruits;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvReportWriterImpl implements CsvReportWriter {

    private static final String HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public String generateReport(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            StringBuilder reportBuilder = new StringBuilder();
            reportBuilder.append(HEADER)
                    .append("banana, " + storageOfFruits.get("banana")
                            + System.lineSeparator())
                    .append("apple, " + storageOfFruits.get("apple"));
            String textInReport = reportBuilder.toString();
            writer.write(textInReport);
            return textInReport;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + fileName, e);
        }
    }
}
