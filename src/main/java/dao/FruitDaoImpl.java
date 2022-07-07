package dao;

import db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(String key, int value) {
        Storage.fruitMap.put(key, value);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitMap;
    }

    @Override
    public int get(String key) {
        return Storage.fruitMap.get(key) == null ? 0 : Storage.fruitMap.get(key);
    }
}
