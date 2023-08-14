package core.basesyntax.db;

import java.util.HashMap;

import java.util.Map;

public class FruitStorage {
    private final Map<String, Integer> fruitDb = new HashMap<>();

    // Integer change to Fruit

    public void updateFruitQuantity(String fruit, int quantityChange) {
        int currentQuantity = fruitDb.getOrDefault(fruit, 0);
        fruitDb.put(fruit, currentQuantity + quantityChange);
    }
    public Map<String,Integer>getMap () {
        return fruitDb;
    }
}
