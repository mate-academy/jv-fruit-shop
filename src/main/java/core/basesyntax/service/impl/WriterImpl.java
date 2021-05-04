package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Writer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterImpl implements Writer {

    @Override
    public boolean writer(String toFilePath) {
        try (FileWriter fileWriter = new FileWriter(toFilePath)) {
            for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
                String row = entry.getKey().getType()
                        + "," + entry.getValue()
                        + System.lineSeparator();
                fileWriter.write(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to a file", e);
        }
        return true;
    }
}
