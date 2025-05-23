package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import static core.basesyntax.model.FruitStorage.storage;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (!storage.containsKey(fruit)) {
            storage.put(fruit, transaction.getQuantity());
            return;
        }
        storage.put(fruit, storage.get(fruit) + transaction.getQuantity());
    }
}
