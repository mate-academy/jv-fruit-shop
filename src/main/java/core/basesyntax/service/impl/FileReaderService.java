package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitException;
import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderService implements ReaderService {
    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new FruitException("Can't read from file: " + fileName);
        }
    }
}
