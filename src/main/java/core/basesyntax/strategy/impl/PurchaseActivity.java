package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.strategy.StoreActivities;

public class PurchaseActivity implements StoreActivities {
    @Override
    public void doActivity(StorageTransaction transaction) {
        Storage.getStorage().merge(transaction.getFruit(),
                -transaction.getQuantity(), Integer::sum);
    }
}
