package core.basesyntax.util.impl;

import core.basesyntax.util.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private String filePath;

    public FileReaderImpl(String fileName) {
        this.filePath = fileName;
    }

    @Override
    public List<String> readLines() {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file with provided path: " + filePath);
        }
    }
}
