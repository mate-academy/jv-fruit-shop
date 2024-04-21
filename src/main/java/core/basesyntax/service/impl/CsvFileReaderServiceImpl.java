package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> read(Path pathToFile) {
        try {
            return Files.readAllLines(pathToFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file path" + pathToFile, e);
        }
    }
}
