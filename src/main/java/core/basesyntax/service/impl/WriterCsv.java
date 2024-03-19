package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Writer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterCsv implements Writer {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";

    public void writeData(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(HEADER + System.lineSeparator());
            for (Map.Entry<String, Integer> entry : Storage.DATA.entrySet()) {
                fileWriter.write(entry.getKey() + COMMA + entry.getValue()
                        + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file." + filePath);
        }
    }
}
