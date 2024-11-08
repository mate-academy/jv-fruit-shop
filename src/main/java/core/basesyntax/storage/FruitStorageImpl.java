package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class FruitStorageImpl implements FruitStorage {
    private static final Map<String, Integer> fruitsStorage = new HashMap<>();

    @Override
    public int getFruitQuantity(String fruit) {
        return fruitsStorage.getOrDefault(fruit, 0);
    }

    @Override
    public void updateFruitQuantity(String fruit, int quantity) {
        fruitsStorage.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruitsStorage);
    }

    @Override
    public void addFruits(String fruit, int quantity) {
        fruitsStorage.merge(fruit, quantity, Integer::sum);
    }
}
