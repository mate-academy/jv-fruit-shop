package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (!FruitStorage.storage.containsKey(fruit)) {
            FruitStorage.storage.put(fruit, transaction.getQuantity());
            return;
        }
        FruitStorage.storage
                .put(fruit, FruitStorage.storage
                        .get(fruit) + transaction.getQuantity());
    }
}
