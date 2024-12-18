package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private final Path filePath;

    public FileReaderImpl(String filename) {
        this.filePath = Path.of(filename);
    }

    public List<String> read() {
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
