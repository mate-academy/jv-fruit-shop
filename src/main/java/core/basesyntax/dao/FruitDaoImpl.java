package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(String fruit, Integer quantity) {
        FruitStorage.storage.put(fruit, quantity);
    }

    @Override
    public Integer get(String fruit) {
        return FruitStorage.storage.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.storage;
    }
}
