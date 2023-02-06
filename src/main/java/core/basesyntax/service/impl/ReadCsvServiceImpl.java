package core.basesyntax.service.impl;

import core.basesyntax.service.ReadCsvService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCsvServiceImpl implements ReadCsvService {
    private static final String FILE_NAME = "src/main/resources/input.csv";
    private static final int HEADER_LINE_NUMBER = 1;

    @Override
    public List<String> readCsvFile() {
        try {
            return Files.readAllLines(Path.of(FILE_NAME))
            .stream()
            .skip(HEADER_LINE_NUMBER)
            .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + FILE_NAME);
        }
    }
}
