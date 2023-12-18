package core.basesyntax.strategy.impl;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ActivityHandler;

public class SupplyActivity implements ActivityHandler {
    @Override
    public void updateBalance(FruitTransaction transaction) {
        if (storage.containsKey(transaction.getFruit())) {
            int newValue = storage.get(transaction.getFruit())
                    + transaction.getQuantity();
            storage.put(transaction.getFruit(), newValue);
        } else {
            storage.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
