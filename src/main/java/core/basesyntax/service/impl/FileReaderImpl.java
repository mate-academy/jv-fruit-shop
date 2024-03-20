package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.parser.DataParserImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<FruitTransactionDto> readFile(String filePath) {
        try {
            List<String> strings = Files.readAllLines(Paths.get(filePath));
            return new DataParserImpl().pars(strings);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filePath, e);
        }
    }
}
