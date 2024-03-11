package core.basesyntax.impl;

import core.basesyntax.service.ReadCsvService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadCsvServiceImpl implements ReadCsvService {

    @Override
    public List<String> readFromFile(String filePath) {
        handleErrors(filePath);

        Path path = Path.of(filePath);
        List<String> fruitTransactions;

        try {
            fruitTransactions = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + filePath, e);
        }
        return fruitTransactions;
    }

    private void handleErrors(String data) {
        if (data == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
        if (!Files.exists(Path.of(data))) {
            throw new IllegalArgumentException("File does not exist: " + data);
        }
    }
}
