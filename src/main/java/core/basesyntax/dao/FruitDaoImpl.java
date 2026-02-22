package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private final Storage storage;

    public FruitDaoImpl(Storage storage) {
        if (storage == null) {
            throw new IllegalArgumentException("Storage can't be null");
        }
        this.storage = storage;
    }

    @Override
    public void update(String fruit, String quantity) {
        if (fruit == null || quantity == null) {
            throw new IllegalArgumentException("Fruit or quantity can't be null");
        }
        storage.update(fruit, quantity);
    }

    @Override
    public Map<String, String> getAll() {
        return storage.snapshot();
    }

    @Override
    public String getQuantity(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key can't be null");
        }
        return storage.get(key);
    }
}
