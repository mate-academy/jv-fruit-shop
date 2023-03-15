package core.basesyntax.strategy.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.database.StorageOfFruits;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        StorageOfFruits.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());

    }
}
