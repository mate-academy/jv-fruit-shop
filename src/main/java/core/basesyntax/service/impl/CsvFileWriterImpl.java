package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public void writeToFile(String filePath, List<Fruit> fruits) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write header
            writer.append(HEADER_LINE);
            writer.append(System.lineSeparator());

            // Write data
            for (Fruit fruit : fruits) {
                writer.append(fruit.getName());
                writer.append(COMMA);
                writer.append(String.valueOf(fruit.getQuantity()));
                writer.append(System.lineSeparator());
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + filePath, e);
        }
    }
}
