package core.basesyntax.strategy.impl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        Storage.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
