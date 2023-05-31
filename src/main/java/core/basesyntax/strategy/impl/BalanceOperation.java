package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationsStrategy;

public class BalanceOperation implements OperationsStrategy {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > 0) {
            Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Quantity of fruit must me greater than 0 "
                    + fruitTransaction.getQuantity());
        }
    }
}
