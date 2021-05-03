package dao;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, Integer amount) {
        Storage.getFruits().put(fruit, amount);
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.getFruits().get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getDB() {
        return Storage.getDB();
    }
}
