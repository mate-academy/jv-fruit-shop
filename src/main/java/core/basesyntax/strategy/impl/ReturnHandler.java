package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int newAmount = FruitStorage.fruitStorage.get(transaction.getFruit())
                + transaction.getQuantity();
        FruitStorage.fruitStorage.put(transaction.getFruit(), newAmount);
    }
}
