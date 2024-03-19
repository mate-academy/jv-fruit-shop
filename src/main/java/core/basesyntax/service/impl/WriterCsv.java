package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Writer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterCsv implements Writer {
    private final String filePath;

    public WriterCsv(String filePath) {
        this.filePath = filePath;
    }

    public void writeData() {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<String, Integer> entry : Storage.data.entrySet()) {
                fileWriter.write(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file.");
        }
    }
}
