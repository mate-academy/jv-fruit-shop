package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public boolean contains(String fruit) {
        return Storage.fruits.containsKey(fruit);
    }

    @Override
    public void addFruit(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public void updateQuantity(String fruit, int quantity) {
        if (!contains(fruit)) {
            addFruit(fruit, quantity);
        } else {
            Storage.fruits.remove(fruit);
            addFruit(fruit, quantity);
        }
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruits;
    }
}
