package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationsStrategy;

public class PurchaseOperation implements OperationsStrategy {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer fruitBalance = Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0);
        if (fruitBalance >= fruitTransaction.getQuantity()) {
            Storage.storage.put(fruitTransaction.getFruit(),
                    fruitBalance - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("There isn't or enough "
                    + fruitTransaction.getFruit() + " in fruitTransaction shop");
        }
    }
}
