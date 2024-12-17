package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private final Path filePath;

    public FileReaderImpl() {
        this.filePath = Path.of("reportToRead.csv");
    }

    public List<String> read(String filename) {
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
