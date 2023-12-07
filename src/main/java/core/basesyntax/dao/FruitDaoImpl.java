package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, Integer quantity) {
        Storage.storageFruit.put(fruit, quantity);
    }

    @Override
    public Integer get(String fruit) {
        return Storage.storageFruit.get(fruit);
    }
}
