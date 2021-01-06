package db;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class FruitStorage {
    public static Map<Fruit, Integer> fruitStorage = new HashMap<>();

    public static Map<Fruit, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
