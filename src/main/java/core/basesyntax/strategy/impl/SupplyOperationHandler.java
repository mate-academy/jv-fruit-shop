package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        if (Storage.storage.containsKey(fruit)) {
            int newQuantity = Storage.storage.get(fruit)
                    + quantity;
            Storage.storage.put(fruit, newQuantity);
        } else {
            Storage.storage.put(fruit, quantity);
        }
    }
}
