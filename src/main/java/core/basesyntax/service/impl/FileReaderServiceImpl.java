package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String filePath) {
        try {
            List<String> readData = Files.readAllLines(Path.of(filePath));
            return readData;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
