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
    public void put(Fruit.Type fruitType, Integer value) {
        storage.getFruitDataBase().put(fruitType, value);
    }

    @Override
    public Integer get(Fruit.Type fruitType) {
        return storage.getFruitDataBase().get(fruitType);
    }

    @Override
    public Map<Fruit.Type, Integer> getAll() {
        return storage.getFruitDataBase();
    }
}
