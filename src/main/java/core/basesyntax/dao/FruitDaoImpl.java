package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void set(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public void add(String fruit, int quantity) {
        Storage.fruits.replace(fruit, get(fruit) + quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        checkKeyPresence(fruit);
        if (quantity > Storage.fruits.get(fruit)) {
            throw new RuntimeException("No fruits for purchase");
        }
        Storage.fruits.replace(fruit, get(fruit) - quantity);
    }

    @Override
    public int get(String fruit) {
        checkKeyPresence(fruit);
        return Storage.fruits.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(Storage.fruits);
    }

    private void checkKeyPresence(String fruit) {
        if (!Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("We don't have such fruit: " + fruit);
        }
    }
}

