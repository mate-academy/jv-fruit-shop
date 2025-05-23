package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import static core.basesyntax.model.FruitStorage.storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        storage.put(fruit, transaction.getQuantity());
    }
}

