package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        boolean isInvalid = !Storage.FRUIT_STORAGE.containsKey(fruit)
                || Storage.FRUIT_STORAGE.get(fruit) - quantity < 0;
        if (isInvalid) {
            throw new RuntimeException("Not enough quantity of fruit " + fruit);
        }
        Storage.FRUIT_STORAGE.put(fruit, Storage.FRUIT_STORAGE.get(fruit) - quantity);
    }
}
