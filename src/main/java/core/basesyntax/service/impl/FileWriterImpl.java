package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter<String> {
    @Override
    public void write(String data, String path) {
        try {
            Files.write(Path.of(path), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write the file to the directory " + path, e);
        }
    }
}
