package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FruitDB {
    private final Map<String, Integer> fruitDB;

    public FruitDB() {
        fruitDB = new HashMap<>();
    }

    public void add(String name, Integer quantity) {
        if (fruitDB.containsKey(name)) {
            Integer currentQuantity = fruitDB.get(name);
            fruitDB.put(name, quantity + currentQuantity);
        } else {
            fruitDB.put(name, quantity);
        }
    }

    public void remove(String name, Integer quantity) {
        if (fruitDB.containsKey(name)) {
            if (Objects.equals(quantity, fruitDB.get(name))) {
                fruitDB.remove(name);
            } else if (fruitDB.get(name) > quantity) {
                Integer currentQuantity = fruitDB.get(name);
                fruitDB.put(name, currentQuantity - quantity);
            } else {
                throw new RuntimeException("Cant remove " + quantity + " " + name
                        + "because have " + fruitDB.get(name));
            }
        } else {
            throw new RuntimeException("Cant remove " + name
                    + "because don't have this in DB");
        }
    }

    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruitDB);
    }
}
