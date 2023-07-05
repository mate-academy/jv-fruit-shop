package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadDailyTransactionsImpl implements ReadDailyTransactions {

    public List<String> getListOfTransactions(String filePath) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        if (!dataFromFile.isEmpty()) {
            dataFromFile.remove(0);
        }
        return dataFromFile;
    }
}
