package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;
import model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, Integer value) {
        Storage.fruitHashMap.put(fruit, value);
    }

    @Override
    public void put(Fruit fruit, Integer count) {
        Storage.fruitHashMap.put(fruit, count);
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.fruitHashMap.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getMap() {
        return Storage.fruitHashMap;
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getEntries() {
        return Storage.fruitHashMap.entrySet();
    }
}
