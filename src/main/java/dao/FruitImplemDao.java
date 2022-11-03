package dao;

import core.basesyntax.Storage;

public class FruitImplemDao implements DaoFruit {
    @Override
    public void addFruits(String fruit, int amount) {
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public int getAmountOfFruit(String fruit) {
        return Storage.fruits.get(fruit);
    }
}
