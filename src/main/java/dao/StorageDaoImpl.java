package dao;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void putFruit(String key, Integer value) {
        Storage.storage.put(key,value);
    }

    @Override
    public List<String> getAllFruits() {
        return new ArrayList<>(Storage.storage.entrySet())
                .stream()
                .map(Object::toString)
                .toList();
    }

    @Override
    public Map<String, Integer> getMap() {
        return Storage.storage;
    }
}
