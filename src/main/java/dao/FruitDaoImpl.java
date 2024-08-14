package dao;

import db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruitName, Integer quantity) {
        Storage.fruits.put(fruitName, quantity);
    }

    @Override
    public int get(String fruitName) {
        return Storage.fruits.get(fruitName);
    }
}
