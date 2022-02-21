package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    public static final int EMPTY_QUANTITY = 0;

    @Override
    public void updateQuantity(String fruit, Integer amount) {
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public Set<String> getFruits() {
        return Storage.fruits.keySet();
    }

    @Override
    public Integer getFruitQuantity(String fruit) {
        if (!Storage.fruits.containsKey(fruit)) {
            return getDefaultQuantity();
        }
        return Storage.fruits.get(fruit);
    }

    private Integer getDefaultQuantity() {
        return EMPTY_QUANTITY;
    }
}
