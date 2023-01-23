package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    public static final int TABLE_TITTLE_INDEX = 1;

    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath)).stream()
                    .skip(TABLE_TITTLE_INDEX)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + filePath, e);
        }
    }
}
