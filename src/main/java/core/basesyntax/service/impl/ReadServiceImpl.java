package core.basesyntax.service.impl;

import core.basesyntax.service.ReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadServiceImpl implements ReadService {
    private static final int HEADING = 1;

    @Override
    public List<String> readData(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName)).stream()
                    .skip(HEADING)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
    }
}
