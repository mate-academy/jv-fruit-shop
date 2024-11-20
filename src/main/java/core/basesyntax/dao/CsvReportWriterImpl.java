package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static core.basesyntax.storage.Storage.storageOfFruits;

public class CsvReportWriterImpl implements CsvReportWriter {

    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String generateReport(String fileName) {
        StringBuilder reportDataBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> fruitNameQuantityEntry : storageOfFruits.entrySet()) {
            String fruitName = fruitNameQuantityEntry.getKey();
            Integer quantity = fruitNameQuantityEntry.getValue();
            reportDataBuilder.append(fruitName).append(COMMA).append(quantity);
        }
        String reportData = reportDataBuilder.toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(reportData);
            return reportData;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file in direction: " + fileName, e);
        }
    }
}
