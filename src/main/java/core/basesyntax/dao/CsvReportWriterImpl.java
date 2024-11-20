package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static core.basesyntax.storage.Storage.storageOfFruits;

public class CsvReportWriterImpl implements CsvReportWriter {

    private static final String HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public String generateReport(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(reportData);
            return reportData;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + fileName, e);
        }
    }
}
