package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        if (!storage.containsKey(fruit)) {
            storage.put(fruit, transaction.getQuantity());
            return;
        }
        storage.put(fruit, storage.get(fruit) + transaction.getQuantity());
    }
}
