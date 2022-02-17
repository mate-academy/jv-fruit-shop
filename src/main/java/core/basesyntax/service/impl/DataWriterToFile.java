package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class DataWriterToFile implements FileWriter {

    public static final String FIRST_LINE = "fruit,quantity";
    public static final String COMA = ",";

    @Override
    public void writeData(Map<Fruit, Integer> data, String toFileName) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(toFileName))) {
            StringBuilder dataToWrite = new StringBuilder().append(FIRST_LINE)
                    .append(System.lineSeparator());
            data.forEach((key, value) -> dataToWrite.append(key.getName()).append(COMA)
                    .append(value).append(System.lineSeparator()));
            writer.write(dataToWrite.toString());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file by path: " + toFileName, e);
        }
    }
}
