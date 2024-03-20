package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.CantReadFromFileException;
import core.basesyntax.service.FruitDataReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFruitDataReaderImpl implements FruitDataReaderService {
    @Override
    public List<FruitTransactionDto> readData(String fileName) {
        try {
            List<String> strings = Files.readAllLines(Path.of(fileName));
            FruitDataParser fruitDataParser = new FruitDataParser();
            return fruitDataParser.parse(strings);
        } catch (IOException e) {
            throw new CantReadFromFileException("Can't read from file: " + fileName);
        }
    }
}
