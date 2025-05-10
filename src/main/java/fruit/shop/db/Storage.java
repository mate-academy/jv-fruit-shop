package fruit.shop.db;

import fruit.shop.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    private static Map<Fruit, Integer> storage = new HashMap<>();

    public static void put(Fruit fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }

    public static Integer get(Fruit fruit) {
        return storage.get(fruit);
    }

    public static Set<Map.Entry<Fruit, Integer>> entrySet() {
        return storage.entrySet();
    }
}
