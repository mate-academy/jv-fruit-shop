package core.basesyntax.service.impl;

import core.basesyntax.service.FileReadService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilerReadServiceImpl implements FileReadService {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + filePath, e);
        }
    }
}

