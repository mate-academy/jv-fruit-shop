package core.basesyntax.services;

import core.basesyntax.exceptions.WrongDateException;
import core.basesyntax.parsers.ParseToFile;
import core.basesyntax.transactions.Transaction;
import java.time.LocalDate;

public class Supply implements StorageOperation {

    @Override
    public boolean updateTransactionTable(String filePath, String type,
                                          Integer quantity, LocalDate expirationDate) {
        if (expirationDate.isAfter(LocalDate.now())) {
            Transaction transaction = new Transaction("s", type, quantity, expirationDate);
            new ParseToFile().writeToFile(transaction, filePath);
            return true;
        }
        throw new WrongDateException("Can't supply spoilt fruit");
    }
}
