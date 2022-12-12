package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.TransactionHandler;

public class TransactionHandlerImpl implements TransactionHandler {
    @Override
    public void addToBalance(String fruit, Integer quantity) {
        if (!Storage.fruitsStorage.containsKey(fruit)) {
            Storage.fruitsStorage.put(fruit, quantity);
        } else {
            Storage.fruitsStorage.replace(fruit, Storage.fruitsStorage.get(fruit) + quantity);
        }

    }

    @Override
    public void takeFromBalance(String fruit, Integer quantity) {
        if (!Storage.fruitsStorage.containsKey(fruit)) {
            Storage.fruitsStorage.put(fruit, -quantity);
        } else {
            Storage.fruitsStorage
                    .replace(fruit,Storage.fruitsStorage.get(fruit) - quantity);
        }

    }
}
