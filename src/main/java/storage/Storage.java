package storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public Storage() {

    }

    public static String stringReport() {
        String fruit = "";
        for (String key : fruits.keySet()) {
            fruit += key + "," + fruits.get(key) + "\n";
        }
        return "fruit,quantity" + "\n"
                + fruit;
    }

    public Map<String, Integer> getFruits() {
        return fruits;
    }

    public void setFruits(Map<String, Integer> fruits) {
        fruits = fruits;
    }

    public static void put(String name, int amount) {
        fruits.put(name,amount);
    }
}
