package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        int oldQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);
        if (quantity > 0) {
            Storage.fruitStorage.put(fruit, oldQuantity + quantity);
        } else {
            throw new RuntimeException("Invalid quantity of fruit" + quantity);
        }
    }
}
