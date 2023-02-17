package core.basesyntax.dao;

import core.basesyntax.model.Transaction;

public interface StorageDao {
    void addToStorage(Transaction transaction);
    void removeFromStorage(Transaction transaction);
    void updateStorage(Transaction transaction);
}
