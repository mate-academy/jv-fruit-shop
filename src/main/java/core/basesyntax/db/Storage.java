package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Fruit, Integer> recordsMap = new HashMap<>();

    public static Map<Fruit, Integer> getAll() {
        return recordsMap;
    }

    public static Integer get(Fruit fruit) {
        return recordsMap.get(fruit);
    }

    public static String addPair(Fruit fruit, Integer quantity) {
        recordsMap.put(fruit, quantity);
        return "Succesfully added pair {" + fruit.name() + ", " + quantity + "}";
    }

    public static String updatePair(Fruit fruit, Integer quantity) {
        recordsMap.put(fruit, quantity);
        return "Succesfully updated pair {" + fruit.name() + ", " + quantity + "}";
    }

    public static String removePair(Fruit fruit, Integer quantity) {
        recordsMap.remove(fruit);
        return "Succesfully removed pair {" + fruit.name() + ", " + quantity + "}";
    }
}
