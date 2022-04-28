package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lines;
        File file = new File(fileName);
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't get this file " + fileName);
        }
        return lines;
    }
}
