package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Integer getBalance(String fruit) {
        return Storage.fruitStock.get(fruit);
    }

    @Override
    public boolean addBalance(String fruit, int quantity) {
        Storage.fruitStock.put(fruit, quantity);
        return Storage.fruitStock.containsKey(fruit)
                && Storage.fruitStock.get(fruit) == quantity;
    }

    @Override
    public void updateBalance(String fruit, int quantity) {
        Storage.fruitStock.put(fruit, quantity);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAllEntries() {
        return Storage.fruitStock.entrySet();
    }
}
