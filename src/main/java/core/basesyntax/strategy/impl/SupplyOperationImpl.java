package core.basesyntax.strategy.impl;

import core.basesyntax.database.StorageOfFruits;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    @Override
    public void calculateFruit(FruitTransaction fruitTransaction) {
        int countOfFruit = StorageOfFruits.fruitStorage.get(fruitTransaction.getFruit());
        StorageOfFruits.fruitStorage.put(fruitTransaction.getFruit(),
                countOfFruit + fruitTransaction.getQuantity());
    }
}
