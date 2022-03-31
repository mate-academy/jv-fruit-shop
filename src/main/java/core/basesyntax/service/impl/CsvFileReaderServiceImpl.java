package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String pathName) {
        List<String> readFromFile;
        try {
            readFromFile = Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + pathName, e);
        }
        return readFromFile;
    }
}
