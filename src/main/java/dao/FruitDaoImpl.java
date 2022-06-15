package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    public void add(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    public Integer get(String fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return Storage.fruits.entrySet();
    }
}
