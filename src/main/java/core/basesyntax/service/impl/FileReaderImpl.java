package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        try {
            Path path = Path.of(ClassLoader.getSystemResource(fileName).toURI());
            return Files.readAllLines(path);
        } catch (Exception e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
