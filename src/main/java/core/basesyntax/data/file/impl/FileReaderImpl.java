package core.basesyntax.data.file.impl;

import core.basesyntax.data.file.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private final Path pathToFile;

    public FileReaderImpl(String pathToFile) {
        this.pathToFile = Path.of(pathToFile);
    }

    @Override
    public List<String> readAll() {
        try {
            return Files.readAllLines(pathToFile);
        } catch (IOException e) {
            throw new RuntimeException("Problems when trying to read from file " + pathToFile, e);
        }
    }
}
