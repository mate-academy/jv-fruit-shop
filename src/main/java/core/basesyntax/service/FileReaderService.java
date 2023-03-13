package core.basesyntax.service;

import core.basesyntax.exception.FruitException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderService {
    public static List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new FruitException("Can't read from file: " + fileName);
        }
    }
}
