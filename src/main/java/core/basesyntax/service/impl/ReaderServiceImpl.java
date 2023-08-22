package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int HEADER_ROW = 0;

    @Override
    public List<String> readFromFile(String fileName) {
        try {
            List<String> list = Files.readAllLines(Path.of(fileName));
            list.remove(HEADER_ROW);
            return list;
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + fileName, e);
        }
    }
}
