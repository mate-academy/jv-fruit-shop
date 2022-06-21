package dao;

import db.Storage;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public int get(String fruit) {
        return Storage.getFruitStorage().get(fruit);
    }

    @Override
    public boolean remove(String fruit) {
        if (Storage.getFruitStorage().containsKey(fruit)) {
            Storage.getFruitStorage().remove(fruit);
        } else {
            throw new RuntimeException(fruit + " was not found in your storage");
        }
        return true;
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
