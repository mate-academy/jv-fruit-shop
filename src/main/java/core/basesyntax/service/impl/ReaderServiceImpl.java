package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> list;
        Path path = Paths.get(filePath);
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file. " + e);
        }
        return list;
    }
}
