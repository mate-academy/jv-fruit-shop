package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderServiceImpl implements ReaderService {
    private static final String FILE_PATH = "src/main/resources/input.csv";

    @Override
    public List<String> readFile() {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("File not exist " + FILE_PATH, e);
        }
        return dataFromFile;
    }
}
