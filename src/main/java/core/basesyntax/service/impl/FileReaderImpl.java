package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file " + e.getMessage(), e);
        }
    }
}
