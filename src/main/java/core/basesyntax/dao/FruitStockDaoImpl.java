package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitStockDaoImpl implements FruitStockDao {
    private final Storage storage;

    public FruitStockDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void put(String fruit, Integer quantity) {
        storage.getFruitStorage().put(fruit, quantity);
    }

    public int get(String fruit) {
        return storage.getFruitStorage().getOrDefault(fruit, 0);
    }
}
