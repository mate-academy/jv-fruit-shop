package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.StorageHandler;

public class AddToStorage implements StorageHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void add(FruitTransaction fruitTransaction) {
        int currentQuantity = Storage.storage
                .getOrDefault(fruitTransaction.getFruit(), DEFAULT_VALUE);
        Storage.storage.put(fruitTransaction.getFruit(),
                currentQuantity + fruitTransaction.getQuantity());
    }
}
