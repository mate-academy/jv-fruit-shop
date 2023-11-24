package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;

public class FruitDao {

    public void setQuantity(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    public int getQuantity(String fruit) {
        return Storage.fruits.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getBalance() {
        return new HashMap<>(Storage.fruits);
    }
}
