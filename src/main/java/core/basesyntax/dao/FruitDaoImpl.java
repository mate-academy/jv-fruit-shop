package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, int amount) {
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public int getFruitAmount(String fruit) {
        return Storage.fruits.get(fruit);
    }
}
