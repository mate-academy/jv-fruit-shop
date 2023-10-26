package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public int get(String name) {
        return FruitStorage.fruits.getOrDefault(name, 0);
    }

    @Override
    public void add(String fruit, int quantity) {
        FruitStorage.fruits.put(fruit, quantity);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return FruitStorage.fruits.entrySet();
    }
}
