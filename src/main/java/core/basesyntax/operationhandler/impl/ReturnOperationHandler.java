package core.basesyntax.operationhandler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.OperationHandler;

public class ReturnOperationHandler extends OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (!storageDao.containsFruit(fruit)) {
            storageDao.addFruit(fruit, quantity);
        } else {
            storageDao.mergeQuantity(fruit, quantity);
        }
    }
}
