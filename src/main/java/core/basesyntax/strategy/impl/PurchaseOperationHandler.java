package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (!Storage.storage.containsKey(fruit) || Storage.storage.get(fruit) - quantity < 0) {
            throw new RuntimeException("Quantity is negative for fruit: " + fruit);
        } else {
            int newQuantity = Storage.storage.get(fruit) - quantity;
            Storage.storage.put(fruit, newQuantity);
        }
    }
}
