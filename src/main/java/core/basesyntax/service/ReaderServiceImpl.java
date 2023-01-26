package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readData(String filePath) {
        List<String> list;
        try {
            list = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + filePath);
        }
        return list;
    }
}
