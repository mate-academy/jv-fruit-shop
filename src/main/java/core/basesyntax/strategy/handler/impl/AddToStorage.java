package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class AddToStorage {
    public static void add(FruitTransaction transaction) {
        int currentQuantity = Storage.storage
                .getOrDefault(transaction.getFruit(), 0);
        Storage.storage.put(transaction.getFruit(),
                currentQuantity + transaction.getQuantity());
    }
}
