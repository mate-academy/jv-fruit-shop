package core.basesyntax.operationhandler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.OperationHandler;

public class PurchaseOperationHandler extends OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int storageQuantity = storageDao.getQuantity(fruit);
        if (quantity >= storageQuantity) {
            storageDao.mergeQuantity(fruit, -quantity);
        } else {
            throw new RuntimeException("Can't purchase required quantity of " + fruit + ": " + quantity + "."
                    + "Quantity in storage: " + storageQuantity);
        }
    }
}
