package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderServiceImpl implements DataReaderService {
    @Override
    public List<String> readData(String sourceLocation) {
        try {
            return Files.readAllLines(Paths.get(sourceLocation));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + sourceLocation, e);
        }
    }
}
