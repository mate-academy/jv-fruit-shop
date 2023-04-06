package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFile(String path) {
            List<String> dataFromFile;
            try {
                dataFromFile = Files.readAllLines(Path.of(path));
            } catch (IOException e) {
                throw new RuntimeException("Cant read data from file " + path, e);
            }
            return dataFromFile;
    }
}
