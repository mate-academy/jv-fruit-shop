package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String sourceFilePath) {
        try {
            return Files.readAllLines(Paths.get(sourceFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file by the path " + sourceFilePath, e);
        }
    }
}
