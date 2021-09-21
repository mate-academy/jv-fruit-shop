package dao;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void add(Fruit operationFruit, int value) {
        Storage.storageFruits.put(operationFruit, value);
    }

    @Override
    public int get(Fruit operationFruit) {
        return Storage.storageFruits.getOrDefault(operationFruit, 0);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.storageFruits;
    }
}
