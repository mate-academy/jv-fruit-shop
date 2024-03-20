package service.impl;

import dto.FruitTransactionDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.DataParser;
import service.FruitDataReaderService;

public class CsvFruitDataReaderService implements FruitDataReaderService {
    private final DataParser<FruitTransactionDto> fruitDataParser;

    public CsvFruitDataReaderService(DataParser<FruitTransactionDto> fruitDataParser) {
        this.fruitDataParser = fruitDataParser;
    }

    @Override
    public List<FruitTransactionDto> read(String filePath) {
        try {
            List<String> strings = Files.readAllLines(Path.of(filePath));
            return fruitDataParser.parse(strings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
