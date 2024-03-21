package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String,Integer> fruits = new HashMap<>();

    public void addFruit(String nameFruit, int quantity) {
        fruits.put(nameFruit,quantity);
    }

    public Integer getFruitQuantity(String nameFruit) {
        return fruits.get(nameFruit);
    }

    public Map<String, Integer> getFruits() {
        return fruits;
    }
}
