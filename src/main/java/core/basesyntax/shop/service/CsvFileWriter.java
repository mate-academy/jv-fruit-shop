package core.basesyntax.shop.service;

import core.basesyntax.shop.model.Fruit;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class CsvFileWriter implements FileWriter {

    @Override
    public void createReportFile(Map<Fruit, Integer> fruitReport, String filePath) {
        try (Writer writer = new java.io.FileWriter(filePath)) {
            writer.append("fruit,quantity").append(System.lineSeparator());
            for (Map.Entry<Fruit, Integer> entry : fruitReport.entrySet()) {
                writer.append(entry.getKey().getType())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + filePath, e);
        }
    }
}
