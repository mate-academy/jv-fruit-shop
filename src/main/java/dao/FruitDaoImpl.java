package dao;

import db.Storage;

public class FruitDaoImpl implements FruitsDao {
    @Override
    public void add(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public int get(String fruit) {
        return Storage.fruits.get(fruit);
    }
}
