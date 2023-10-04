package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readDataFromTheFile(File fileName) {
        try {
            return Files.readAllLines(fileName.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Impossible to read data from the file " + fileName);
        }
    }
}
