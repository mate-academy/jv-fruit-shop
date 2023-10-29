package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, Integer amount) {
        Storage.STORAGE.put(fruit, amount);
    }

    @Override
    public Integer getQuantity(String fruit) {
        return Storage.STORAGE.getOrDefault(fruit, 0);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return Storage.STORAGE.entrySet();
    }
}
