package dao;

import db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String key, int value) {
        if (value < 0) {
            throw new RuntimeException("Count of fruits can't be less than 0");
        }
        if (Storage.fruits.containsKey(key)) {
            value += get(key);
        }
        Storage.fruits.put(key, value);
    }

    @Override
    public void remove(String key, int value) {
        if (value < 1) {
            throw new RuntimeException("You can't buy less than 1 fruits");
        } else if (!Storage.fruits.containsKey(key)) {
            throw new RuntimeException("There isn't fruit with name: " + key);
        } else if (Storage.fruits.get(key) < value) {
            throw new RuntimeException("You can't buy more fruits than your shop have" + key);
        }
        Storage.fruits.put(key, Storage.fruits.get(key) - value);
    }

    @Override
    public Integer get(String key) {
        return Storage.fruits.get(key);
    }
}
