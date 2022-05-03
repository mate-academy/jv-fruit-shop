package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader implements ReaderService {
    @Override
    public List<String> read(String filePath) {
        Path path = Paths.get(filePath);
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
        return lines;
    }
}
