package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final Storage storage;

    public BalanceOperationHandler() {
        this.storage = new Storage();
    }

    @Override
    public void operateFruits(FruitTransaction fruitTransaction) {
        storage.getFruitsStorage().put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
