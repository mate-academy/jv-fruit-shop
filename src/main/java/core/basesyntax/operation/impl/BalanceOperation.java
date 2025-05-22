package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        storage.put(fruit, transaction.getQuantity());
    }
}

