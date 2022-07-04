package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.FruitTransaction;

public class BalanceTransactionImpl implements FruitTransaction {

    @Override
    public void getTransaction(String fruit, int quantity) {
        Fruit currentFruit = Fruit.valueOf(fruit.toUpperCase());
        Storage.getFruitStore().put(currentFruit, quantity);
    }
}

