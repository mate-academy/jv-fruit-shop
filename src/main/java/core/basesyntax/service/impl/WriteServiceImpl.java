package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteServiceImpl implements WriterService {
    @Override
    public void write(String content, String path) {
        try {
            Files.write(Path.of(path), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write a file: " + path, e);
        }
    }
}
