package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final String PATHNAME = "src/main/resources/operations.csv";

    @Override
    public List<String> read() {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(PATHNAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
        return dataFromFile;
    }
}
