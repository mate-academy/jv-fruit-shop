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

    public void put(Fruit fruit, Integer count) {
        Storage.fruitHashMap.put(fruit, count);
    }

    public Integer get(Fruit fruit) {
        return Storage.fruitHashMap.get(fruit);
    }

    public Map<Fruit, Integer> getMap() {
        return Storage.fruitHashMap;
    }

    public Set<Map.Entry<Fruit, Integer>> getEntries() {
        return Storage.fruitHashMap.entrySet();
    }

}
