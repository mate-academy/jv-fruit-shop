package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    private static HashMap<String,Integer> fruits;

    private Storage() {
        this.fruits = new HashMap<>();
    }

    public static Storage of() {
        return new Storage();
    }

    public HashMap<String, Integer> getFruits() {
        return fruits;
    }

    public static int getFruitCount(String fruit) {
        return fruits.get(fruit);
    }

    public void setFruits(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }
}
