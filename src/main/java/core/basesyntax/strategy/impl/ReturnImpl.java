package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnImpl implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        FruitStorage.fruits.put(transaction.getFruit(),
                FruitStorage.fruits.containsKey(transaction.getFruit())
                        ? FruitStorage.fruits.get(transaction.getFruit())
                        + transaction.getQuantity()
                        : transaction.getQuantity());
    }
}
