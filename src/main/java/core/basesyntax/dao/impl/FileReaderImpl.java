package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> fruits;
        try {
            fruits = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file" + filePath, e);
        }
        return fruits;
    }
}
