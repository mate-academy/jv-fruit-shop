package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private final Map<String, Integer> fruitStorage = new HashMap<>();

    @Override
    public void update(String fruitName, int quantity) {

        if (fruitName == null || fruitName.isEmpty()) {
            throw new IllegalArgumentException("Fruit name can't be null or empty");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative for fruit: "
                    + fruitName);
        }

        fruitStorage.put(fruitName, quantity);
    }

    @Override
    public Integer get(String fruitName) {

        return fruitStorage.getOrDefault(fruitName, 0);
    }

    @Override
    public Map<String, Integer> getAll() {

        return new HashMap<>(fruitStorage);
    }
}
