package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String filePath) {
        if (filePath == null || !filePath.endsWith("csv")) {
            throw new RuntimeException("Incorrect data");
        }
        List<String> list;
        try {
            list = Files.readAllLines(Path.of(filePath));
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        return list;
    }
}
