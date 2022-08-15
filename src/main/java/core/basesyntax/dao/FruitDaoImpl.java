package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName, Integer fruitQuantity) {
        Storage.fruits.put(fruitName, fruitQuantity);
    }

    @Override
    public Integer get(String fruitName) {
        return Storage.fruits.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }
}
