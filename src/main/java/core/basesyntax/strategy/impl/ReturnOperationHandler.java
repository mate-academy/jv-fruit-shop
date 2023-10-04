package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final Storage storage;

    public ReturnOperationHandler() {
        this.storage = new Storage();
    }

    @Override
    public void operateFruits(FruitTransaction fruitTransaction) {
        int currentQty = storage.getFruitsStorage().get(fruitTransaction.getFruit());
        storage.getFruitsStorage().put(fruitTransaction.getFruit(),
                currentQty + fruitTransaction.getQuantity());
    }
}
