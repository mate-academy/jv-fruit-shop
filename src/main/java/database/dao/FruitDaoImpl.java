package database.dao;

import database.Storage;
import java.util.Map;
import service.exception.InvalidDataException;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName, Integer quantity) {
        Storage.STORAGE.put(fruitName, quantity);
    }

    @Override
    public Integer get(String fruitName) {
        if (Storage.STORAGE.containsKey(fruitName)) {
            return Storage.STORAGE.get(fruitName);
        }
        throw new InvalidDataException("No such fruit '" + fruitName + "' in the storage");
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.STORAGE;
    }
}
