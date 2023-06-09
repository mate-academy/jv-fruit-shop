package core.basesyntax.stategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.stategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.FRUITS.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
