package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private static final Storage storage = new Storage();

    @Override
    public boolean contains(String fruitName) {
        return storage.getMapOfFruits().containsKey(fruitName);
    }

    @Override
    public void add(String fruitName) {
        storage.getMapOfFruits().put(fruitName, 0);
    }

    @Override
    public Integer get(String fruitName) {
        return storage.getMapOfFruits().get(fruitName);
    }

    @Override
    public Map<String, Integer> getMap() {
        return storage.getMapOfFruits();
    }

    @Override
    public void update(String fruitName, Integer newAmount) {
        storage.getMapOfFruits().put(fruitName, newAmount);
    }
}
