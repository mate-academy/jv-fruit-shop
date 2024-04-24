package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;
import model.FruitType;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(FruitType fruitType, Integer count) {
        Storage.fruitHashMap.put(fruitType, count);
    }

    @Override
    public Set<Map.Entry<FruitType, Integer>> getEntries() {
        return Storage.fruitHashMap.entrySet();
    }

    @Override
    public Map<FruitType, Integer> getMap() {
        return Storage.fruitHashMap;
    }
}
