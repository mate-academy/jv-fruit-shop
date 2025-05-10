package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readLines(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file with provided path: " + filePath);
        }
    }
}
