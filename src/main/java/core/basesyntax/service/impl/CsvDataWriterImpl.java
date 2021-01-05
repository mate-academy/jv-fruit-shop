package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvDataWriterImpl implements DataWriter {
    @Override
    public void writeReport(String dataToWrite, String filepath) {
        try {
            Files.write(Path.of(filepath), dataToWrite.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file: " + filepath, e);
        }
    }
}
