package core.basesyntax.service;

import core.basesyntax.db.Storage;

public interface StorageService {
    void actionToStorage(TransactionLog transactionLog, Storage storage);
}
