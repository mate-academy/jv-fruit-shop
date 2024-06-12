package core.basesyntax.service.impl;

import core.basesyntax.service.CantWorkWithThisFileException;
import core.basesyntax.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new CantWorkWithThisFileException("Cannot read file: " + filePath,e);
        }
    }
}
