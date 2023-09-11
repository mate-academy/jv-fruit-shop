package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, Integer amount) {
        FruitStorage.STORAGE.put(fruit, amount);
    }

    @Override
    public Integer get(String fruit) {
        return FruitStorage.STORAGE.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.STORAGE;
    }
}
