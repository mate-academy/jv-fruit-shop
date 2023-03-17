package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() > FruitStorage.fruitStorage.get(transaction.getFruit())) {
            throw new RuntimeException("Not enough "
                    + transaction.getFruit() + "'s on store to purchase");
        }
        int newAmount = FruitStorage.fruitStorage.get(transaction.getFruit())
                - transaction.getQuantity();
        FruitStorage.fruitStorage.put(transaction.getFruit(), newAmount);
    }
}
