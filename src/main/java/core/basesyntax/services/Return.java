package core.basesyntax.services;

import core.basesyntax.parsers.ParseToFile;
import core.basesyntax.transactions.Transaction;
import java.time.LocalDate;

public class Return implements StorageOperation {

    @Override
    public boolean updateTransactionTable(String filePath, String type,
                                          Integer quantity, LocalDate expirationDate) {
        Transaction transaction = new Transaction("r", type, quantity, expirationDate);
        new ParseToFile().writeToFile(transaction, filePath);
        return true;
    }
}
