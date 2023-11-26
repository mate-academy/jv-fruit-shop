package service;

import db.FruitStorage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterImpl implements FileWriter {
    private static final String REPORT_FIRST_ROW = "fruit,quantity" + System.lineSeparator();
    private static final String SPLIT_REGEX = ",";

    public void write(FruitStorage fruitInventory, String reportFileName) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(reportFileName))) {
            writer.write(REPORT_FIRST_ROW);
            for (Map.Entry<String, Integer> entry : fruitInventory.getAllFruitEntries()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(entry.getKey())
                                .append(SPLIT_REGEX)
                                .append(entry.getValue())
                                .append(System.lineSeparator());
                writer.write(stringBuilder.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + reportFileName, e);
        }
    }
}
