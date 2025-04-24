package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    private final Storage storage;

    public SupplyOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        storage.setFruitBalance(fruitTransaction.getFruit(),
                storage.getFruitBalance(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
