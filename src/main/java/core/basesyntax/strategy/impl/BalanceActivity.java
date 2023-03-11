package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.strategy.StoreActivities;

public class BalanceActivity implements StoreActivities {
    @Override
    public void doActivity(StorageTransaction transaction) {
        Storage.getStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
