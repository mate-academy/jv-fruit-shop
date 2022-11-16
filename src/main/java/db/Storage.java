package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage;

    public Storage() {
        storage = new HashMap<>();
    }

    public Storage(Map<String, Integer> storage) {
        this.storage = storage;
    }

    public boolean isAvailable(String fruit) {
        return fruit != null && storage.containsKey(fruit);
    }

    public Integer getQuantityFruit(String fruit) {
       return isAvailable(fruit) ? storage.get(fruit) : Integer.MIN_VALUE;
    }

    public void addItem(String fruit) {
        if (isAvailable(fruit)) {
            System.out.println("Such fruit already exist or you entered null");
        } else {
            storage.put(fruit, 0);
        }
    }
}
