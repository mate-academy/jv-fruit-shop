package dao.impl;

import dao.DataDao;
import java.util.Map;
import storage.DataStorage;

public class DataDaoImpl implements DataDao {
    private final Map<String, Integer> fruitMap = DataStorage.FRUIT_MAP;

    @Override
    public void putValue(String key, Integer value) {
        fruitMap.put(key, value);
    }

    @Override
    public Integer getValue(String key) {
        return fruitMap.get(key);
    }

    @Override
    public Map<String, Integer> getFruitMap() {
        return fruitMap;
    }
}
