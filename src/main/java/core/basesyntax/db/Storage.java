package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruits = new HashMap<>();

    public Storage(Map<String, Integer> fruits) {
        this.fruits = fruits;
    }

    public Storage() {
        this.fruits = fruits;
    }

    public Map<String, Integer> getFruits() {
        return fruits;
    }

    public void setFruits(Map<String, Integer> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        if (fruits.get(fruit) == null
                || fruits.get(fruit) == 0
                || quantity > fruits.get(fruit)) {
            throw new RuntimeException("No this fruit on the storage! Avaiable: "
                    + fruits.getOrDefault(fruit, 0) + "   Requested: " + quantity);
        }
        fruits.put(fruit, fruits.get(fruit) - quantity);
    }

}
