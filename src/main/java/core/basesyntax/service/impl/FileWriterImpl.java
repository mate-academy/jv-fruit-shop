package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String message, String path) {
        try {
            Files.writeString(Path.of(path), message);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + path, e);
        }
    }
}
