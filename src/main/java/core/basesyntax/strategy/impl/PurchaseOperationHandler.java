package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private Storage storage;

    public PurchaseOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        int currentQuantity = storage.getFruitQuantity(fruit);
        int purchaseQuantity = transaction.getQuantity();
        int operationResult = currentQuantity - purchaseQuantity;

        if (purchaseQuantity < 0) {
            throw new RuntimeException("Transaction \"purchase\" can`t have negative value");
        }
        if (operationResult < 0) {
            throw new RuntimeException("Transaction \"purchase\" can`t be executed for "
                    + fruit + ". There aren't enough fruits in the storage.");
        }
        storage.setFruitQuantity(fruit, operationResult);
    }
}
