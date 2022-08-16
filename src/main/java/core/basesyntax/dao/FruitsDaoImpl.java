package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void add(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }
}
