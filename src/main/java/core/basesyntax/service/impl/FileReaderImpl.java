package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try {
            Path path = Path.of(filePath);
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
