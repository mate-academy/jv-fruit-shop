package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void doCalculation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (Storage.storage.containsKey(fruit)) {
            int newQuantity = Storage.storage.get(fruitTransaction.getFruit())
                    + quantity;
            Storage.storage.put(fruit, newQuantity);
        } else {
            Storage.storage.put(fruit, quantity);
        }
    }
}
