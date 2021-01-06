package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements DataWriter {
    @Override
    public void write(Map<Fruit, Integer> storage, String destinationFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationFile))) {
            StringBuilder report = new StringBuilder("fruit,quantity");
            report.append(System.lineSeparator());
            for (Map.Entry<Fruit, Integer> line : storage.entrySet()) {
                report.append(line.getKey().getFruitName())
                        .append(",")
                        .append(line.getValue().toString())
                        .append(System.lineSeparator());
            }
            bufferedWriter.write(report.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to the file " + destinationFile);
        }
    }
}
