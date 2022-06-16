package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public List<String> readFile(String fileName) {
        try {
            List<String> output = Files.readAllLines(Path.of(fileName));
            return output;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file from path: " + fileName, e);
        }
    }
}
