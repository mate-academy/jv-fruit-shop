package core.basesyntax.operationhandler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.OperationHandler;

public class SupplyOperationHandler extends OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (fruitDao.containsFruit(fruit)) {
            fruitDao.mergeQuantity(fruit, quantity);
        } else {
            fruitDao.addFruit(fruit, quantity);
        }

    }
}
