package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        int balanceQuantity = transaction.getQuantity();

        if (balanceQuantity < 0) {
            throw new RuntimeException("Transaction \"balance\" can`t have negative value");
        }

        storage.setFruitQuantity(fruit, balanceQuantity);
    }
}
