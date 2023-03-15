package core.basesyntax.impl;

import core.basesyntax.service.ReadDataFromFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    private static final String FILE_PATH = "src/main/java/core/basesyntax/input.csv";

    @Override
    public List<String> readData() {
        List<String> operations;
        try {
            operations = Files.readAllLines(Path.of(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file.", e);
        }
        return operations;
    }
}
