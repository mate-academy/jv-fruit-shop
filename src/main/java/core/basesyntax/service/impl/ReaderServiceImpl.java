package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private static final int HEADER_ROW = 1;

    @Override
    public List<String> readData(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName)).stream()
                    .skip(HEADER_ROW)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
    }
}
