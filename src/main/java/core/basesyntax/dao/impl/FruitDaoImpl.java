package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(String fruit, int quantity) {
        FruitStorage.fruits.put(fruit, quantity);
    }

    @Override
    public void add(String fruit, int quantity) {
        if (FruitStorage.fruits.containsKey(fruit)) {
            FruitStorage.fruits.put(
                    fruit, FruitStorage.fruits.get(fruit) + quantity);
            return;
        }
        FruitStorage.fruits.put(fruit, quantity);
    }

    @Override
    public void subtract(String fruit, int quantity) {
        if (FruitStorage.fruits.containsKey(fruit)) {
            FruitStorage.fruits.put(
                    fruit, FruitStorage.fruits.get(fruit) - quantity);
            return;
        }
        throw new RuntimeException("Impossible to get product from empty productStorage!");
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return FruitStorage.fruits;
    }
}
