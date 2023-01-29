package core.basesyntax.service.Impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String fileName = "src/main/resources/database.csv";
    List<String> operations;

    @Override
    public List<String> readFromFile() {
        try {
            operations = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read date from file " + fileName + e);
        }
        return operations;
    }

}
