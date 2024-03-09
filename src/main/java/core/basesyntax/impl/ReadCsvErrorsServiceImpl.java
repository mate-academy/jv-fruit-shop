package core.basesyntax.impl;

import core.basesyntax.service.HandleErrorsService;
import core.basesyntax.service.ReadCsvService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadCsvErrorsServiceImpl implements ReadCsvService, HandleErrorsService {

    @Override
    public List<String> readFromFile(String filePath) {
        handleErrors(filePath);

        Path path = Path.of(filePath);
        List<String> fruitTransactions;

        try {
            fruitTransactions = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file", e);
        }
        return fruitTransactions;
    }

    @Override
    public void handleErrors(String data) {
        if (data == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
        if (!Files.exists(Path.of(data))) {
            throw new IllegalArgumentException("File does not exist: " + data);
        }
    }
}
