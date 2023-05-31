package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int LINE_WITH_HEADERS = 0;

    @Override
    public List<String> readFromFile(String filePath) {
        try {
            List<String> list = Files.readAllLines(Path.of(filePath));
            list.remove(LINE_WITH_HEADERS);
            return list;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
