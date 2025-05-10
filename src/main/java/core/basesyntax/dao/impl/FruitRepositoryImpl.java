package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitRepository;
import core.basesyntax.db.Database;
import core.basesyntax.exception.StorageException;
import java.util.Map;

public class FruitRepositoryImpl implements FruitRepository {
    private final Map<String, Integer> db = Database.storage;

    @Override
    public void add(String fruit, int quantity) {
        db.merge(fruit, quantity, Integer::sum);
    }

    @Override
    public void remove(String fruit, int quantity) {
        if (db.get(fruit) - quantity < 0) {
            throw new StorageException("Not enough " + fruit + " in storage to remove");
        }
        db.put(fruit, db.get(fruit) - quantity);
    }

    @Override
    public boolean hasFruit(String fruit) {
        return db.containsKey(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Map.copyOf(db);
    }
}
