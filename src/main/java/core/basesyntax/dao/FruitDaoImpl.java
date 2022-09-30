package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;

public class FruitDaoImpl implements FruitDao {
    @Override
    public int getAmount(String fruitName) {
        return Storage.getFruits().get(fruitName);
    }

    @Override
    public void add(String fruitName, int quantity) {
        Storage.getFruits().put(fruitName, quantity);
    }

    @Override
    public void changeAmount(String fruitName, int newAmount) {
        Storage.getFruits().replace(fruitName, newAmount);
    }

    @Override
    public HashMap<String, Integer> getStorageData() {
        return Storage.getFruits();
    }
}
