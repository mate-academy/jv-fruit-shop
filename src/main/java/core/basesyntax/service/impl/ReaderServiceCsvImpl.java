package core.basesyntax.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import core.basesyntax.service.ReaderService;

public class ReaderServiceCsvImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return strings;
    }
}

