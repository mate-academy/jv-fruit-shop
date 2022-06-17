package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {

    @Override
    public List<String> read(String pathname) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(pathname));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + pathname);
        }
        return dataFromFile;
    }
}
