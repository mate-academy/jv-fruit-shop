package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StorageService;

public class SupplyStorageService implements StorageService {
    @Override
    public void updateStorage(FruitTransaction transaction) {
        Storage.fruits.compute(transaction.getFruit(), (k, v) -> v + transaction.getQuantity());
    }
}
