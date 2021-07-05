package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String inputFile) {
        try {
            return Files.readAllLines(Path.of(inputFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + inputFile, e);
        }
    }
}
