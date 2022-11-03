package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(String fruitName, int quantity) {
        FruitStorage.fruitStorage.put(fruitName, quantity);
    }

    @Override
    public Integer get(String fruitName) {
        return FruitStorage.fruitStorage.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.fruitStorage;
    }
}
