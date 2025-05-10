package core.basesyntax.service.filereader;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FruitDataParser;
import core.basesyntax.service.exeptions.DataReaderExeption;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitDataReaderServiceImpl implements FruitDataReaderService {
    private final DataParser<FruitTransactionDto> fruitDataParser;

    public FruitDataReaderServiceImpl(DataParser<FruitTransactionDto> fruitDataParser) {
        this.fruitDataParser = fruitDataParser;
    }

    @Override
    public List<FruitTransactionDto> readData(String filePath) {
        try {
            List<String> strings = Files.readAllLines(Path.of(filePath));
            FruitDataParser fruitDataParser = new FruitDataParser();
            return fruitDataParser.parse(strings);
        } catch (IOException e) {
            throw new DataReaderExeption("Cant read from file!" + e);
        }
    }
}
