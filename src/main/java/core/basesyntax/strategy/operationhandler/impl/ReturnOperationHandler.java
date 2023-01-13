package core.basesyntax.strategy.operationhandler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operationhandler.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (!fruitDao.containsFruit(fruit)) {
            fruitDao.addFruit(fruit, quantity);
        } else {
            fruitDao.mergeQuantity(fruit, quantity);
        }
    }
}
