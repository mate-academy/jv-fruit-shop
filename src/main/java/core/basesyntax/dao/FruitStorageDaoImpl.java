package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(String fruit, Integer quantity) {
        FruitStorage.FRUIT_STORAGE.put(fruit, quantity);
    }

    @Override
    public int get(String fruit) {
        return FruitStorage.FRUIT_STORAGE.get(fruit);
    }

}
