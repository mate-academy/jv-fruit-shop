package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String report) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }
    }
}
