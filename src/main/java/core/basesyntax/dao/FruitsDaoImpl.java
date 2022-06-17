package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public boolean add(String fruit, int amount) {
        Storage.fruits.put(fruit, amount);
        return true;
    }

    @Override
    public int get(String fruit) {
        if (Storage.fruits.containsKey(fruit)) {
            return Storage.fruits.get(fruit);
        } else {
            throw new RuntimeException(fruit + "is not available at the storage");
        }
    }

    @Override
    public boolean remove(String fruit) {
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.remove(fruit);
        } else {
            throw new RuntimeException(fruit + " is not available at the storage");
        }
        return true;
    }

    @Override
    public Map<String, Integer> getFruitsAndQuantityAsMap() {
        return Storage.fruits;
    }
}
