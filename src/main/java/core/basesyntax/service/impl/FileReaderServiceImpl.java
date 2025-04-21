package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readFile(String filePath) {
        List<String> fruitTransaction;
        try {
            fruitTransaction = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Cant read file: " + filePath, e);
        }
        return fruitTransaction;
    }
}
