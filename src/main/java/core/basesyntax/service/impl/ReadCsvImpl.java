package core.basesyntax.service.impl;

import core.basesyntax.service.ReadCsvService;
import exception.FileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadCsvImpl implements ReadCsvService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> fruitBalance;
        try {
            fruitBalance = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new FileException("Can`t read data from file " + filePath);
        }
        return fruitBalance;
    }
}


