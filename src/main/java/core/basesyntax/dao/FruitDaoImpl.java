package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruits(String fruitName, Integer fruitAmount) {
        Storage.storage.put(fruitName, fruitAmount);
    }

    @Override
    public Integer get(String fruit) {
        return Storage.storage.get(fruit);
    }
}
