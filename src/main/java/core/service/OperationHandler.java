package core.service;

import core.db.FruitTransaction;
import core.db.StorageService;

public interface OperationHandler {
    void addTransaction(FruitTransaction transaction,
                        StorageService<FruitTransaction> storageService);
}
