package core.basesyntax.strategy.impl;

import core.basesyntax.database.StorageOfFruits;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    @Override
    public void calculateFruit(FruitTransaction fruitTransaction) {
        StorageOfFruits.fruitStorage.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
