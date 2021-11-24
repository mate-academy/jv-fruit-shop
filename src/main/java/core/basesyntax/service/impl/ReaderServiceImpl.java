package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String fromFileName) {
        List<String> fruitData;
        try {
            fruitData = Files.readAllLines(Path.of(fromFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from list" + fromFileName, e);
        }
        return fruitData;
    }
}
