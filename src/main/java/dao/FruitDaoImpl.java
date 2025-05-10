package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public boolean containsKey(String key) {
        return Storage.fruitHashMap.containsKey(key);
    }

    @Override
    public void put(String string, Integer count) {
        Storage.fruitHashMap.put(string, count);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getEntries() {
        return Storage.fruitHashMap.entrySet();
    }
}
