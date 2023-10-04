package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        int oldQuantity = Storage.FRUIT_STORAGE.getOrDefault(fruit, 0);
        if (quantity < 0) {
            throw new RuntimeException("Invalid quantity of fruit " + quantity);
        }
        Storage.FRUIT_STORAGE.put(fruit, oldQuantity + quantity);
    }
}
