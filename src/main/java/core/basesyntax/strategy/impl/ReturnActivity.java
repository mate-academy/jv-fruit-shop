package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StoreActivities;

public class ReturnActivity implements StoreActivities {
    @Override
    public void doActivity(FruitTransaction transaction) {
        Storage.getStorage().merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
