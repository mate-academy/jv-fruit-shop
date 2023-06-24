package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readAllLines(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException ioe) {
            throw new RuntimeException("Can't find file by path: " + filePath, ioe);
        }
    }
}
