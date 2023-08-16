package dao;

import db.Storage;
import java.util.List;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Fruit add(Fruit fruit) {
        Storage.fruits.put(fruit.getName(), fruit.getQuantity());
        return fruit;
    }

    @Override
    public List<Fruit> getAll() {
        return null;
    }

    @Override
    public Fruit get(String name) {
        return null;
    }
}



