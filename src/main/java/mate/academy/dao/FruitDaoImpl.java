package mate.academy.dao;

import java.util.Map;
import mate.academy.db.Storage;

public class FruitDaoImpl implements FruitDao {
    public void add(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }
}
