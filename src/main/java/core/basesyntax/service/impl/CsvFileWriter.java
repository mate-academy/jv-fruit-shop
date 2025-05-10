package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriter implements FileWriter {
    @Override
    public void writeDataToFile(String report, String filePath) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the File: " + filePath, e);
        }
    }
}
