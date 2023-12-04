package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    private final Storage storage;

    public FruitDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void put(String fruitName, int quantity) {
        storage.getFruits().put(fruitName, quantity);
    }

    @Override
    public int get(String fruitName) {
        return storage.getFruits().getOrDefault(fruitName, 0);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getInventoryEntries() {
        return storage.getFruits().entrySet();
    }
}
