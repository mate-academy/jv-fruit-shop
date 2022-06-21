package dao;

import db.Storage;

import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public int get(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public boolean remove(String fruit) {
        if (Storage.fruitStorage.containsKey(fruit)) {
            Storage.fruitStorage.remove(fruit);
        } else {
            throw new RuntimeException(fruit + " was not found in your storage");
        }
        return true;
    }

    @Override
    public void add(String fruit, int amount) {
        Storage.fruitStorage.put(fruit, amount);
    }

    @Override
    public Map<String, Integer> getCurrentFruitAmount() {
        return Storage.fruitStorage;
    }
}
