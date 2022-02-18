package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    public static final int EMPTY_AMOUNT = 0;

    @Override
    public void addQuantity(String fruit, Integer amount) {
        if (!Storage.fruits.containsKey(fruit)) {
            addFruit(fruit);
        }
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + amount);
    }

    @Override
    public void subtractQuantity(String fruit, Integer amount) {
        if (!Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("Can't reduce the quantity of" + fruit);
        }
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) - amount);
    }

    @Override
    public Set<String> getFruits() {
        return Storage.fruits.keySet();
    }

    @Override
    public Integer getFruitQuantity(String fruit) {
        return Storage.fruits.get(fruit);
    }

    private void addFruit(String fruit) {
        Storage.fruits.put(fruit, EMPTY_AMOUNT);
    }
}
