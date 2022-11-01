package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataWriterCsvImpl implements DataWriter {
    @Override
    public void write(String data, String filePath) {
        try {
            Files.write(Path.of(filePath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data to file:" + filePath);
        }
    }
}
