package dao;

import database.Storage;
import java.util.Map;
import model.Fruit;

public class FruitDaoImpl implements FruitDao {
    private Storage storage;

    public FruitDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void put(Fruit fruit, Integer value) {
        storage.getFruitDataBase().put(fruit, value);
    }

    @Override
    public Integer get(Fruit fruit) {
        return storage.getFruitDataBase().get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return storage.getFruitDataBase();
    }
}
