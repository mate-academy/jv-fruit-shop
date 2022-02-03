package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DataWriterToFile implements DataWriter {
    @Override
    public void writeData(Map<Fruit, Integer> data, String toFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFileName))) {
            StringBuilder dataToWrite = new StringBuilder().append("fruit,quantity")
                    .append(System.lineSeparator());
            data.forEach((key, value) -> dataToWrite.append(key.getName()).append(",")
                    .append(value).append(System.lineSeparator()));
            writer.write(dataToWrite.toString());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file by path: " + toFileName, e);
        }
    }
}
