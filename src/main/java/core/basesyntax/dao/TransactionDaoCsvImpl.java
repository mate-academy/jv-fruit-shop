package core.basesyntax.dao;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransitionServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TransactionDaoCsvImpl implements TransactionDao {

    @Override
    public List<Transaction> readFromFile(String fileName) {
        Path filePath = Paths.get(fileName);
        List<String> readFromFile;
        try {
            readFromFile = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }
        return new TransitionServiceImpl().getTransactionsList(readFromFile);
    }
}
