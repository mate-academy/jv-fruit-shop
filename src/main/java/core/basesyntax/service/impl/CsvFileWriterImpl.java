package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void writeToFile(String filePathTo, Map<Fruit, Integer> fruits) {
        try (FileWriter writer = new FileWriter(filePathTo)) {
            writer.write("fruit,quantity\n");
            for (Map.Entry<Fruit, Integer> entry: fruits.entrySet()) {
                writer.append(entry.getKey().getName());
                writer.append(",");
                writer.append(entry.getValue().toString());
                writer.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePathTo);
        }
    }
}
