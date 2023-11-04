package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitDaoImpl implements FruitDao {
    private final Storage storage;

    public FruitDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void put(String fruitName, int quantity) {
        storage.fruits.put(fruitName, quantity);
    }

    @Override
    public int get(String fruitName) {
        return storage.fruits.getOrDefault(fruitName, 0);
    }

    @Override
    public Storage getStorage() {
        return storage;
    }

}
