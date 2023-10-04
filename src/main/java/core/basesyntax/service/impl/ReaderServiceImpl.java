package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dataFromFile;
        try {
            Path path = Paths.get(filePath);
            dataFromFile = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("It is not possible to read data from the file via"
                    + " this path - " + filePath + e);
        }
        return dataFromFile;
    }
}
