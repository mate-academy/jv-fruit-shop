package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Integer getValue(Fruit key) {
        return Storage.fruits.get(key);
    }

    @Override
    public Integer putValue(String key, Integer value) {
        return Storage.fruits.put(new Fruit(key), value);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getEntrySet() {
        return Storage.fruits.entrySet();
    }
}
