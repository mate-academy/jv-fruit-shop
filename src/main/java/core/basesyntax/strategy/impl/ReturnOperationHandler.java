package core.basesyntax.strategy.impl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int amount = Storage.getOrDefault(fruitTransaction.getFruit(), DEFAULT_VALUE);
        Storage.put(fruitTransaction.getFruit(), amount + fruitTransaction.getQuantity());
    }
}
