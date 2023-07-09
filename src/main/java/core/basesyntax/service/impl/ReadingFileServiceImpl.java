package core.basesyntax.service.impl;

import core.basesyntax.service.ReadingFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingFileServiceImpl implements ReadingFileService {
    @Override
    public List<String> readingDataFromFile(String inputFile) {
        try {
            return Files.readAllLines(Paths.get(inputFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + inputFile, e);
        }
    }
}
