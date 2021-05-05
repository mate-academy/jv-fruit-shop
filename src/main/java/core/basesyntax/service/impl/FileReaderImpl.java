package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private List<String> records = new ArrayList<>();

    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath, e);
        }
    }
}
