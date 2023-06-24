package core.basesyntax.strategy.impl;

import core.basesyntax.database.StorageOfFruits;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationImpl implements OperationHandler {
    @Override
    public void calculateFruit(FruitTransaction fruitTransaction) {
        int countOfFruit = StorageOfFruits.fruitStorage.get(fruitTransaction.getFruit());
        if (countOfFruit >= fruitTransaction.getQuantity()) {
            StorageOfFruits.fruitStorage.put(fruitTransaction.getFruit(),
                    countOfFruit - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Not enough "
                    + fruitTransaction.getFruit() + " in storage "
                    + countOfFruit + ", want to buy " + fruitTransaction.getQuantity());
        }
    }
}
