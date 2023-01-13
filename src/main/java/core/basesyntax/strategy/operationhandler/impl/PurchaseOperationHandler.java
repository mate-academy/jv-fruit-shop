package core.basesyntax.strategy.operationhandler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operationhandler.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int storageQuantity = fruitDao.getQuantity(fruit);
        if (checkQuantity(storageQuantity, quantity)) {
            fruitDao.mergeQuantity(fruit, -quantity);
        } else {
            throw new RuntimeException("Can't purchase required quantity of " + fruit
                    + ": " + quantity + ". "
                    + "Quantity in storage: " + storageQuantity);
        }
    }

    private boolean checkQuantity(int storageQuantity, int quantity) {
        return storageQuantity >= quantity;
    }
}
