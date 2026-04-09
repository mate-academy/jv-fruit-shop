package dao.impl;

import dao.FruitDao;
import db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String fruit, int quantity) {
        FruitStorage.fruits.merge(fruit, quantity, Integer::sum);
    }

    @Override
    public void remove(String fruit, int quantity) {
        int current = getQuantity(fruit);
        FruitStorage.fruits.put(fruit, current - quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return FruitStorage.fruits.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.fruits;
    }
}
