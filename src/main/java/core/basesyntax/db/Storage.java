package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static boolean isAvailable(String fruit) {
        return fruit != null && storage.containsKey(fruit);
    }

    public static Integer getQuantityFruit(String fruit) {
       return isAvailable(fruit) ? storage.get(fruit) : Integer.MIN_VALUE;
    }

    public static void addItems(String[] fruits) {
        for (String fruit: fruits) {
            addItem(fruit);
        }
    }
    public static void addItem(String fruit) {
        if (isAvailable(fruit)) {
            System.out.println("Such fruit already exist or you entered null");
        } else {
            storage.put(fruit, 0);
        }
    }
}
