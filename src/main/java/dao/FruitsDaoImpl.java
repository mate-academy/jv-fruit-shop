package dao;

import db.Storage;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public int get(String fruit) {
        return Storage.getFruitStorage().get(fruit);
    }

    @Override
    public void add(String fruit, int amount) {
        Storage.getFruitStorage().put(fruit, amount);
    }

    @Override
    public Map<String, Integer> getCurrentFruitAmount() {
        return Storage.getFruitStorage();
    }
}
