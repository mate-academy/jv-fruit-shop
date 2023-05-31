package core.basesyntax.strategy.impl;

import core.basesyntax.OperationsStrategy;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class ReturnOperation implements OperationsStrategy {
    @Override
    public void handle(Fruit fruitTransaction) {
        Integer fruitBalance = Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0);
        if (fruitTransaction.getQuantity() > 0) {
            Storage.storage.put(fruitTransaction.getFruit(),
                    fruitBalance + fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Quantity of fruit must me greater than 0 "
                    + fruitTransaction.getQuantity());
        }
    }
}
