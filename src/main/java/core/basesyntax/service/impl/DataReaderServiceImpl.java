package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderServiceImpl implements DataReaderService {
    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read input file! Invalid path: " + filePath, e);
        }
    }
}
