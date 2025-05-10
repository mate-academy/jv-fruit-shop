package core.basesyntax.strategy.impl;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ActivityHandler;

public class PurchaseActivity implements ActivityHandler {
    @Override
    public void updateBalance(FruitTransaction transaction) {
        if (storage.containsKey(transaction.getFruit())) {
            int newValue = storage.get(transaction.getFruit())
                    - transaction.getQuantity();
            if (newValue < 0) {
                throw new RuntimeException("There is no required amount left over");
            }
            storage.put(transaction.getFruit(), newValue);
        } else {
            throw new RuntimeException(transaction.getFruit() + ": Out of stock");
        }
    }
}
