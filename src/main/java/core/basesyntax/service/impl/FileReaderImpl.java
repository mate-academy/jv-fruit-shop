package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String filename) {
        try {
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filename);
        }
    }
}
