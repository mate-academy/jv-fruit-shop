package dao;

import db.Storage;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public int get(String fruit) {
        return Storage.getFruitStorage().get(fruit);
    }

    @Override
    public boolean add(String fruit, int amount) {
        if (fruit == null || amount < 0) {
            throw new RuntimeException("Check your input data.");
        } else if (amount == 0) {
            throw new RuntimeException("There is nothing to add");
        }
        Storage.getFruitStorage().put(fruit, amount);
        return true;
    }

    @Override
    public Map<String, Integer> getCurrentFruitAmount() {
        return Storage.getFruitStorage();
    }
}
