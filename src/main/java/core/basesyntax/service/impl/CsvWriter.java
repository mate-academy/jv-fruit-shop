package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter implements Writer {
    @Override
    public void write(String path, String data) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write file: " + path);
        }
    }
}
