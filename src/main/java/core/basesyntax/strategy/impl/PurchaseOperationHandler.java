package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        int currentQuantity = Storage.FRUITS.getOrDefault(fruit, 0);
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Invalid fruit name");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        if (currentQuantity < quantity) {
            throw new RuntimeException("Quantity is negative for fruit: " + fruit);
        }
        int newQuantity = currentQuantity - quantity;
        Storage.FRUITS.put(fruit, newQuantity);
    }
}
