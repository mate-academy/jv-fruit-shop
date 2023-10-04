package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService<String> {
    @Override
    public void write(String data, String path) {
        try {
            Files.write(Path.of(path), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write the file to the directory " + path, e);
        }
    }
}
