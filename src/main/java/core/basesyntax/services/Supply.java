package core.basesyntax.services;

import core.basesyntax.parsers.ParseToCSV;
import core.basesyntax.parsers.Transaction;

import java.time.LocalDate;

public class Supply implements StorageOperation {

    @Override
    public boolean UpdateTransactionTable(String FilePath, String type, Integer quantity, LocalDate expirationDate) {
        if (expirationDate.isAfter(LocalDate.now())) {
            Transaction transaction = new Transaction("s", type, quantity, expirationDate);
            boolean addSupplyToCSV = new ParseToCSV().writeToFile(transaction, FilePath);
            return true;
        }
        return false;
    }
}
