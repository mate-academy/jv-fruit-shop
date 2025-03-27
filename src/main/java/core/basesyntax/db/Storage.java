package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> FRUIT = new HashMap<>();

    public Storage(Map<String, Integer> fruits) {
        this.FRUIT = fruits;
    }

    public Storage() {
        this.FRUIT = FRUIT;
    }

    public Map<String, Integer> getFruits() {
        return FRUIT;
    }

    public void setFruits(Map<String, Integer> fruits) {
        this.FRUIT = fruits;
    }

    public void addFruit(String fruit, int quantity) {
        FRUIT.put(fruit, FRUIT.getOrDefault(fruit, 0) + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        if (FRUIT.get(fruit) == null
                || FRUIT.get(fruit) == 0
                || quantity > FRUIT.get(fruit)) {
            throw new RuntimeException("No this fruit on the storage! Avaiable: "
                    + FRUIT.getOrDefault(fruit, 0) + "   Requested: " + quantity);
        }
        FRUIT.put(fruit, FRUIT.get(fruit) - quantity);
    }

}
