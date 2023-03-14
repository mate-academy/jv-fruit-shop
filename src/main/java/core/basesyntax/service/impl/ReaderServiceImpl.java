package core.basesyntax.service.impl;

import core.basesyntax.exceptions.ReadDataFromFileException;
import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readDataFromFile(String pathToFile) {
        File file = new File(pathToFile);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new ReadDataFromFileException("Can't read data from file " + pathToFile, e);
        }
    }
}
