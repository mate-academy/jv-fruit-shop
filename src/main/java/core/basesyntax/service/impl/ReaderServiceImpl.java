package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private static final String TITLE = "type";
    private static final int LINES_TO_SKIP = 1;

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> fruit;
        try {
            fruit = Files.lines(Path.of(fileName))
                    .skip(LINES_TO_SKIP)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName);
        }
        return fruit;
    }
}
