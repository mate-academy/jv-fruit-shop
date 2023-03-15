package core.basesyntax.strategy.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.database.StorageOfFruits;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationImpl implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int countOfFruit = StorageOfFruits.get(fruitTransaction.getFruit());
        StorageOfFruits.add(fruitTransaction.getFruit(),
                countOfFruit + fruitTransaction.getQuantity());
    }
}
