package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final Storage storage;

    public SupplyOperationHandler() {
        this.storage = new Storage();
    }

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        int currentQty = storage.getFruitsStorage().get(fruitTransaction.getFruit());
        storage.getFruitsStorage().put(fruitTransaction.getFruit(),
                currentQty + fruitTransaction.getQuantity());
    }
}
