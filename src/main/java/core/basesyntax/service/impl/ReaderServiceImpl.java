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
            fruit = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file " + fileName);
        }
        return fruit.stream()
                .filter(line -> !line.startsWith(TITLE))
                .collect(Collectors.toList());
    }
}
