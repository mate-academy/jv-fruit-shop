package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> content;
        try {
            content = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Cannot get a file content: " + filePath, e);
        }
        return content;
    }
}
