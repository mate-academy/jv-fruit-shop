package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
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
