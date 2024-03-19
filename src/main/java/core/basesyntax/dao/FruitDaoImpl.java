package core.basesyntax.dao;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getFruits() {
        return Storage.STORAGE;
    }

    @Override
    public void addFruit(String fruitName, int quantity) {
        Storage.STORAGE.put(fruitName, quantity);
    }

    @Override
    public int getFruitQuantity(String fruitName) {
        return Storage.STORAGE.get(fruitName);
    }
}
