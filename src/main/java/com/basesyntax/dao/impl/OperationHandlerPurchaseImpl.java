package com.basesyntax.dao.impl;

import com.basesyntax.dao.OperationHandler;
import com.basesyntax.db.impl.StorageImpl;
import com.basesyntax.model.Fruit;

public class OperationHandlerPurchaseImpl implements OperationHandler {
    @Override
    public Fruit apply(Fruit fruit, int amount) {
        if (new StorageImpl().getStorage().containsKey(fruit)) {
            int balance = new StorageImpl().getStorage().get(fruit);
            if (new StorageImpl().getStorage().get(fruit) < amount) {
                throw new RuntimeException("There is not enough fruits in the shop. Balance:"
                        + new StorageImpl().getStorage().get(fruit)
                        + " You want purchase: " + amount);
            } else {
                new StorageImpl().getStorage().replace(fruit, balance - amount);
                return fruit;
            }
        } else {
            throw new RuntimeException("There is not current fruit in the shop: " + fruit);
        }

    }
}
