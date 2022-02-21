package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao<String, Integer> {
    private final Storage storage;

    public FruitDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void addStorage(String fruitName, int amount) {
        if (storage.getFruitsStorage().containsKey(fruitName)) {
            storage.getFruitsStorage().put(fruitName, getFruitCount(fruitName) + amount);
        } else {
            storage.getFruitsStorage().put(fruitName, amount);
        }
    }

    @Override
    public void removeFromStorage(String fruitName, int amount) {
        if (storage.getFruitsStorage().containsKey(fruitName)) {
            int value = getFruitCount(fruitName) - amount;
            if (value >= 0) {
                storage.getFruitsStorage().put(fruitName, value);
            } else {
                throw new RuntimeException("Not enough fruits");
            }
        }
    }

    @Override
    public int getFruitCount(String nameFruit) {
        return storage.getFruitsStorage().get(nameFruit);
    }

    public Map<String, Integer> getAllFruits() {
        return storage.getFruitsStorage();
    }
}
