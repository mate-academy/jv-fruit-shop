package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteServiceImpl implements WriterService {
    @Override
    public void write(String report, Path path) {
        try {
            Files.write(path, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write a file", e);
        }
    }
}
