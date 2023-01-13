package core.basesyntax.operationhandler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.OperationHandler;

public class BalanceOperationHandler extends OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.addFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
