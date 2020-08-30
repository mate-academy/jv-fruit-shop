package core.basesyntax.services;

import java.time.LocalDate;

public interface StorageOperation {
    public boolean updateTransactionTable(String filePath, String type,
                                          Integer quantity, LocalDate expirationDate);
}
