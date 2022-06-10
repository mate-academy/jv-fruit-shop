package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        try (var rows = Files.lines(Paths.get(filePath))) {
            return rows.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file: " + filePath, e);
        }
    }
}
