package core.basesyntax.dao;

import core.basesyntax.db.StorageFruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName, int amountOfFruit) {
        StorageFruit.storage.put(fruitName, amountOfFruit);
    }

    @Override
    public int get(String fruit) {
        return StorageFruit.storage.get(fruit);
    }
}
