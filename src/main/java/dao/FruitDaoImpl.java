package dao;

import storage.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Integer getQuantity(String fruitName) {
        if (Storage.fruits.containsKey(fruitName)) {
            return Storage.fruits.get(fruitName);
        }
        throw new RuntimeException("There is no such fruit in a store " + fruitName);
    }

    @Override
    public void add(String fruitName, Integer amount) {
        Storage.fruits.put(fruitName, amount);
    }
}
