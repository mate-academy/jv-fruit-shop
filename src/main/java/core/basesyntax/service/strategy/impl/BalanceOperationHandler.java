package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        Integer startNumberOfFruit = fruitTransaction.getQuantity();
        Storage.STORAGE.put(fruitTransaction.getFruit(), startNumberOfFruit);
    }
}
