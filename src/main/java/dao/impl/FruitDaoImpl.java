package dao.impl;

import dao.FruitDao;
import database.Storage;
import java.util.Map;
import model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(Fruit fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public Integer getQuantity(Fruit fruit) {
        return Storage.fruits.entrySet().stream()
                .filter(f -> f.getKey().equals(fruit))
                .map(Map.Entry::getValue)
                .findFirst()
                .get();
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruits;
    }
}
