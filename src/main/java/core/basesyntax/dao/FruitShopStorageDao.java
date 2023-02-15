package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.OptionalInt;

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
        int oldValue = fruitStorage.getContent().get(key);
        fruitStorage.getContent().put(key, oldValue - quantity);
    }

    @Override
    public OptionalInt get(String key) {
        return OptionalInt.of(fruitStorage.getContent().get(key));
    }
}
