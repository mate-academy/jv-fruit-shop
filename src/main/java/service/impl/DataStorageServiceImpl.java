package service.impl;

import java.util.Map;
import service.DataStorageService;
import storage.DataStorage;

public class DataStorageServiceImpl implements DataStorageService {
    private final Map<String, Integer> fruitMap = DataStorage.getFruitMap();

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
