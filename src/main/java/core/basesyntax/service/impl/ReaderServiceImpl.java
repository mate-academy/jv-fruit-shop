package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> dateFromFile;
        try {
            dateFromFile = Files.readAllLines(Path.of("src/main/resources/input.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can not read data, please check file: " + filePath, e);
        }
        return dateFromFile;
    }
}
