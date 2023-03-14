package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String path) {
        if (path == null) {
            throw new RuntimeException("Path cannot be null");
        }
        List<String> inputData;
        try {
            inputData = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + path, e);
        }
        return inputData.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
}
