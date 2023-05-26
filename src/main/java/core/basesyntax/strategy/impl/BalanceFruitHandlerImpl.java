package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;

public class BalanceFruitHandlerImpl implements FruitHandler {
    @Override
    public void doAction(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("The balance of fruits in the store"
                    + " cannot be less than zero");
        }
        Storage.getFruitStorage().put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
