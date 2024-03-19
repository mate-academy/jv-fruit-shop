package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Writer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterCsv implements Writer {
    private static final String FILE_PATH = "src/files/fruits_report.csv";

    public void writeData() {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<String, Integer> entry : Storage.data.entrySet()) {
                fileWriter.write(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file.");
        }
    }
}
