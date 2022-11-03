package com.basesyntax.dao.impl;

import com.basesyntax.dao.OperationHandler;
import com.basesyntax.db.impl.StorageImpl;
import com.basesyntax.model.Fruit;

public class OperationHandlerSupplyImpl implements OperationHandler {
    public Fruit apply(Fruit fruit, int amount) {
        if (new StorageImpl().getStorage().containsKey(fruit)) {
            int balance = new StorageImpl().getStorage().get(fruit);
            new StorageImpl().getStorage().replace(fruit, balance + amount);
            return fruit;
        } else {
            throw new RuntimeException("There is not current fruit in the shop: " + fruit);
        }
    }
}
