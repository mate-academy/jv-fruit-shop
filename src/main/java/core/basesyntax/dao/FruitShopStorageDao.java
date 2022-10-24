package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitShopStorageDao implements StorageDao {
    private final Storage fruitStorage = Storage.getInstance();

    @Override
    public void set(String key, int quantity) {
        fruitStorage.getContent().put(key, quantity);
    }

    @Override
    public void add(String key, int quantity) {
        int oldValue = fruitStorage.getContent().getOrDefault(key, 0);
        fruitStorage.getContent().put(key, oldValue + quantity);
    }

    @Override
    public void subtract(String key, int quantity) {
        if (!fruitStorage.getContent().containsKey(key)) {
            throw new RuntimeException("Theres no such fruit: " + key);
        }
        int oldValue = fruitStorage.getContent().get(key);
        if (quantity > oldValue) {
            throw new RuntimeException("You can't remove from storage more than it have (have "
                    + oldValue + ")");
        }
        fruitStorage.getContent().put(key, oldValue - quantity);
    }
}
