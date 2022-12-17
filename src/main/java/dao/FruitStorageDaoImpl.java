package dao;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public boolean add(Fruit fruit, Integer amount) {
        Storage.fruitStorage.put(fruit, amount);
        return true;
    }

    @Override
    public boolean update(Fruit fruit, Integer amount) {
        Storage.fruitStorage.replace(fruit, amount);
        return true;
    }

    @Override
    public Integer getAmountByFruit(Fruit fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Map.copyOf(Storage.fruitStorage);
    }
}
