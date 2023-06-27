package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.LocalStorage;
import java.util.Map;

public class LocalStorageFruitDao implements FruitDao {
    @Override
    public void updateQuantity(String fruit, Integer amount) {
        Integer oldValue = LocalStorage.FRUITS.getOrDefault(fruit, 0);
        LocalStorage.FRUITS.put(fruit, oldValue + amount);
    }

    @Override
    public Map<String, Integer> getFruits() {
        return LocalStorage.FRUITS;
    }
}
