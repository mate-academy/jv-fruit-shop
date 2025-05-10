package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public int get(String fruit) {
        return Storage.storage.get(fruit);
    }
}
