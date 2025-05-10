package core.basesyntax.service.impl;

import core.basesyntax.exception.CantReadFromFileException;
import core.basesyntax.service.FruitDataReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFruitDataReaderImpl implements FruitDataReaderService {
    @Override
    public List<String> readData(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new CantReadFromFileException("Can't read from file: " + fileName);
        }
    }
}
