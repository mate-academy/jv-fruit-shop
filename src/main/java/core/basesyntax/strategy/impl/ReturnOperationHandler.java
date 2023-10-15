package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private Storage storage;

    public ReturnOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        int currentQuantity = storage.getFruitQuantity(fruit);
        int returnQuantity = transaction.getQuantity();
        int operationResult = returnQuantity + currentQuantity;

        if (returnQuantity < 0) {
            throw new RuntimeException("Transaction \"return\" can`t have negative value");
        }

        storage.setFruitQuantity(fruit, operationResult);
    }
}
