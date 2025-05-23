package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        FruitStorage.storage.put(fruit, transaction.getQuantity());
    }
}

