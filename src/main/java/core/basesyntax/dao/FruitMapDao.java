package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitMapDao implements FruitStorageDao {
    private static final int INITIAL_QUANTITY = 0;
    private final Map<Fruit, Integer> fruitMap;

    public FruitMapDao(Map<Fruit, Integer> fruitMap) {
        this.fruitMap = fruitMap;
    }

    @Override
    public void update(Fruit fruit, int quantity) {
        if (!fruitMap.containsKey(fruit)) {
            throw new RuntimeException("Can't find fruit for update");
        }
        fruitMap.put(fruit, quantity);
    }

    @Override
    public int getQuantity(Fruit fruit) {
        checkFruit(fruit);
        return fruitMap.get(fruit);
    }

    private boolean checkFruit(Fruit fruit) {
        if (fruitMap.containsKey(fruit)) {
            return false;
        }
        fruitMap.put(fruit, INITIAL_QUANTITY);
        return true;
    }
}

