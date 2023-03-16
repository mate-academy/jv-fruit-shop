package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderServiceImpl implements DataReaderService {
    @Override
    public List<String> readData(String filePath) {
        List<String> operations;
        try {
            operations = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file.", e);
        }
        return operations;
    }
}
