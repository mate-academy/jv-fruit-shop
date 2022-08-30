package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Integer currentQuantity = Storage.storage.put(transaction.getFruit(), transaction.getCount());
        Storage.storage.put(transaction.getFruit(), currentQuantity + transaction.getCount());
    }
}
