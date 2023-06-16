package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitInventoryManipulator;

public abstract class TransactionHandler {
    protected FruitInventoryManipulator fruitInventoryManipulator;

    public TransactionHandler(FruitInventoryManipulator fruitInventoryManipulator) {
        this.fruitInventoryManipulator = fruitInventoryManipulator;
    }

    public abstract void handle(FruitTransaction transaction);
}
