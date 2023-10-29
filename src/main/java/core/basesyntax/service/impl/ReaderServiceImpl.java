package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            List<String> data = Files.readAllLines(Paths.get(filePath));
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file with path: ", e);
        }
    }
}
