package dao;

import java.util.Map;
import storage.Storage;

public class FruitDaoImpl implements FruitsDao {

    @Override
    public void addFruit(String fruit, int quantity) {
        Storage.fruitsStorage.put(fruit, quantity);
    }

    @Override
    public int getQuantityByFruit(String fruit) {
        return Storage.fruitsStorage.get(fruit);
    }

    @Override
    public Boolean contains(String fruit) {
        return Storage.fruitsStorage.containsKey(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitsStorage;
    }
}
