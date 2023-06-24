package core.basesyntax.services.impl;

import core.basesyntax.services.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String path) {
        List<String> dateFromFile;
        try {
            dateFromFile = Files.readAllLines(Path.of("src/main/java/resources/dataInput.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can not read data, please check file:" + path, e);
        }
        return dateFromFile;
    }
}
