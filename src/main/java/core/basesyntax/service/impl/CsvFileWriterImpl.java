package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void writeToFile(String filePath, List<Fruit> fruits) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write header
            writer.append("fruit,quantity");
            writer.append("\n");

            // Write data
            for (Fruit fruit : fruits) {
                writer.append(fruit.getName());
                writer.append(",");
                writer.append(String.valueOf(fruit.getQuantity()));
                writer.append("\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + filePath, e);
        }
    }
}
