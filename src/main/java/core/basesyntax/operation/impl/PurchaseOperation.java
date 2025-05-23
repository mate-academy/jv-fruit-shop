package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import static core.basesyntax.model.FruitStorage.storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = storage.getOrDefault(fruit, 0);
        int requestedQuantity = transaction.getQuantity();
        if (currentQuantity >= requestedQuantity) {
            storage.put(fruit, currentQuantity - requestedQuantity);
        } else {
            throw new IllegalArgumentException("Not enough " + fruit + " in storage");
        }
    }
}
