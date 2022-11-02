package DAO;

import core.basesyntax.Storage;

public class DAOFruitImplem implements DAOFruit{
    @Override
    public void addFruits(String fruit, int amount) {
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public int getAmountOfFruit(String fruit) {
        return Storage.fruits.get(fruit);
    }
}
