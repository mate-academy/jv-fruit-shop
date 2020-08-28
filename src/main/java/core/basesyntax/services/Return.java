package core.basesyntax.services;

import core.basesyntax.parsers.ParseToCSV;
import core.basesyntax.parsers.Transaction;

import java.time.LocalDate;

public class Return implements StorageOperation {

    @Override
    public boolean UpdateTransactionTable(String FilePath, String type, Integer quantity, LocalDate expirationDate) {
        Transaction transaction = new Transaction("r", type, quantity, expirationDate);
        boolean addReturnToCSV = new ParseToCSV().writeToFile(transaction, FilePath);
        return true;
    }

}
