package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        try {
            Files.write(Path.of(fileName), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName);
        }
    }
}
