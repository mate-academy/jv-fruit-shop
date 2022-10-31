package core.basesyntax.dao.impl;

import core.basesyntax.dao.TransactionHandler;
import core.basesyntax.db.Storage;

public class TransactionHandlerImpl implements TransactionHandler {
    @Override
    public void addToBalance(String fruit, Integer quantity) {
        if (!Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, quantity);
        } else {
            Storage.fruits.replace(fruit, Storage.fruits.get(fruit) + quantity);
        }
    }

    @Override
    public void takeFromBalance(String fruit, Integer quantity) {
        if (!Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, -quantity);
        } else {
            Storage.fruits.replace(fruit, Storage.fruits.get(fruit) - quantity);
        }
    }
}
