package com.basesyntax.strategy.impl;

import com.basesyntax.dao.FruitDao;
import com.basesyntax.dao.FruitDaoImpl;
import com.basesyntax.db.impl.StorageImpl;
import com.basesyntax.model.Fruit;
import com.basesyntax.strategy.OperationHandler;

public class OperationHandlerPurchaseImpl implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(Fruit fruit, int amount) {
        if (new StorageImpl().getStorage().containsKey(fruit)) {
            int balance = fruitDao.getAmountCurrentFruitInShop(fruit);
            if (balance < amount) {
                throw new RuntimeException("There is not enough fruits in the shop. Balance:"
                        + fruitDao.getAmountCurrentFruitInShop(fruit)
                        + " You want purchase: " + amount);
            } else {
                fruitDao.update(fruit, balance - amount);
            }
        } else {
            throw new RuntimeException("There is not current fruit in the shop: " + fruit);
        }
    }
}
