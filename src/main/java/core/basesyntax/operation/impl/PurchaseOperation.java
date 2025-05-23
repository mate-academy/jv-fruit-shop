package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = FruitStorage.storage.getOrDefault(fruit, 0);
        int requestedQuantity = transaction.getQuantity();
        if (currentQuantity >= requestedQuantity) {
            FruitStorage.storage.put(fruit, currentQuantity - requestedQuantity);
        } else {
            throw new IllegalArgumentException("Not enough " + fruit + " in storage");
        }
    }
}
