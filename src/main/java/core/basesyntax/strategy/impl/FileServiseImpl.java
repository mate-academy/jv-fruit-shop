package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiseImpl implements FileService {
    @Override
    public List<String> readFile(String fileName) {
        List<String> fruitOperations;
        try {
            fruitOperations = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        return fruitOperations;
    }

    @Override
    public boolean writeToFile(String data, String fileName) {
        if (data == null) {
            return false;
        }
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + fileName, e);
        }
        return true;
    }
}
