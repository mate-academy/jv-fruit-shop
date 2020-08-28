package core.basesyntax.services;

import java.time.LocalDate;

public interface StorageOperation {
    public boolean UpdateTransactionTable(String FilePath, String type, Integer quantity, LocalDate expirationDate);
}
