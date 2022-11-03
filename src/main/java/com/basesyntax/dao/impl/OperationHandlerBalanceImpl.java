package com.basesyntax.dao.impl;

import com.basesyntax.dao.OperationHandler;
import com.basesyntax.db.impl.StorageImpl;
import com.basesyntax.model.Fruit;

public class OperationHandlerBalanceImpl implements OperationHandler {
    @Override
    public Fruit apply(Fruit fruit, int amount) {
        new StorageImpl().getStorage().put(fruit, amount);
        return fruit;
    }
}
