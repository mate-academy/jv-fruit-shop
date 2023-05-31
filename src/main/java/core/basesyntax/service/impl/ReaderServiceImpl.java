package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private static final String TITLE = "type";

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> fruit;
        try {
            fruit = Files.lines(Path.of(fileName))
                    .skip(1) // Skip the first line
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName);
        }
        return fruit;
    }
}

