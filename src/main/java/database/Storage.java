package database;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Storage {
    private static Map<Fruit, Integer> fruitDataBase = new HashMap<>();

    public Map<Fruit, Integer> getFruitDataBase() {
        return fruitDataBase;
    }
}
