package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName, int count) {
        Storage.fruits.put(fruitName, count);
    }

    @Override
    public Map<String, Integer> get() {
        return Storage.fruits;

    }
}
