package core.basesyntax.service.impl;

import core.basesyntax.exception.ReadFromFileCsvException;
import core.basesyntax.service.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceCsvImpl implements FileReaderService {
    @Override
    public List<String> readData(String path) {
        Path filePath = Path.of(path);
        List<String> strings;
        try {
             return strings = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new ReadFromFileCsvException("Can't read from csv file " + filePath, e);
        }
    }
}
