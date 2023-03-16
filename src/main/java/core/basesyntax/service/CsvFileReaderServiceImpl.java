package core.basesyntax.service;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.service.interfaces.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new FruitShopException("Can`t read from file!");
        }
    }
}
