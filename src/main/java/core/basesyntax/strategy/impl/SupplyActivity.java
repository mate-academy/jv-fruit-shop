package core.basesyntax.strategy.impl;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ActivityHandler;

public class SupplyActivity implements ActivityHandler {
    @Override
    public void updateBalance(FruitTransaction transaction) {
        storage.merge(transaction.getFruit(), transaction.getQuantity(),
                (newValue, oldValue) -> newValue + oldValue);
    }
}
