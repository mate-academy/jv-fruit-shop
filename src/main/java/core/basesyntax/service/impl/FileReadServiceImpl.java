package core.basesyntax.service.impl;

import core.basesyntax.service.FileReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadServiceImpl implements FileReadService {
    private static final int HEADER = 1;

    @Override
    public List<String> readDataFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName)).stream()
                    .skip(HEADER)
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException("Can't read data from file" + fileName, exception);
        }
    }
}
