package dao;

import Storage.Storage;

import java.util.Map;

public class FruitDaoImpl implements FruitsDao {

    @Override
    public void addFruit(String Fruit, int quantity) {
        Storage.fruitsStorage.put(Fruit, quantity);
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
