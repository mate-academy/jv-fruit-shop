package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvFileWriterServiceImpl implements FileWriter {
    @Override
    public void write(String report, String toFile) {
        try {
            Files.writeString(Paths.get(toFile), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + toFile, e);
        }
    }
}
