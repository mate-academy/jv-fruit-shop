package core.basesyntax.strategy.operationhandler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operationhandler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.addFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
