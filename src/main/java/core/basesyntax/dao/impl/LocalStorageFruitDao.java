package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.LocalStorage;
import java.util.Map;

public class LocalStorageFruitDao implements FruitDao {
    @Override
    public void setQuantity(String fruit, Integer quantity) {
        LocalStorage.FRUITS.put(fruit, quantity);
    }

    @Override
    public void addQuantity(String fruit, Integer amount) {
        LocalStorage.FRUITS.put(fruit, getOldValue(fruit) + amount);
    }

    private Integer getOldValue(String fruit) {
        return LocalStorage.FRUITS.getOrDefault(fruit, 0);
    }

    @Override
    public void subtractQuantity(String fruit, Integer amount) {
        LocalStorage.FRUITS.put(fruit, getOldValue(fruit) - amount);
    }

    @Override
    public Map<String, Integer> getFruits() {
        return LocalStorage.FRUITS;
    }
}
