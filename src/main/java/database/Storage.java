package database;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Storage {
    private static Map<Fruit.Type, Integer> fruitDataBase = new HashMap<>();

    public Map<Fruit.Type, Integer> getFruitDataBase() {
        return fruitDataBase;
    }
}
