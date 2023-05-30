package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();
        String fruit = fruitTransaction.getFruit();
        if (!Storage.fruitStorage.containsKey(fruit)
                || Storage.fruitStorage.get(fruit) - quantity < 0) {
            throw new RuntimeException("Not enough quantity of fruit"
                    + fruitTransaction.getFruit());
        } else {
            Storage.fruitStorage.put(fruit,
                    Storage.fruitStorage.get(fruitTransaction.getFruit()) - quantity);
        }
    }
}
