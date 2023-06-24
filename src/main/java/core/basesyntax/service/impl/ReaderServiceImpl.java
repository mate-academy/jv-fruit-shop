package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readFromFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath, e);
        }
    }
}
