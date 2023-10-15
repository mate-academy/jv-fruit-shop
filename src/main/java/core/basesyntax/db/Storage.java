package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Fruit, Integer> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public int getFruitQuantity(Fruit fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public void setFruitQuantity(Fruit fruit, int amount) {
        storage.put(fruit, amount);
    }

    public Map<Fruit,Integer> getAllFruits() {
        return new HashMap<>(storage);
    }
}
