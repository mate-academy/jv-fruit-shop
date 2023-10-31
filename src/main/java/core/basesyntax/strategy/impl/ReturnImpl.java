package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;

public class ReturnImpl implements FruitHandler {
    @Override
    public void calculateFruitOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() >= 0) {
            Storage.fruitStorage.merge(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity(), Integer::sum);
        } else {
            throw new RuntimeException("Quantity must be positive: "
                    + fruitTransaction.getQuantity());
        }
    }
}
