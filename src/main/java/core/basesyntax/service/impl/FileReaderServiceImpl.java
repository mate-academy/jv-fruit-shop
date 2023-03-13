package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Impossible to read this file " + filePath, e);
        }
    }
}
