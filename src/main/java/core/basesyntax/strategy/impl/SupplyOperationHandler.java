package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Invalid fruit name");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        int currentQuantity = Storage.FRUITS.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + quantity;
        Storage.FRUITS.put(fruit, newQuantity);
    }
}
