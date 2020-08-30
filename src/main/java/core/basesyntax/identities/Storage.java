package core.basesyntax.identities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Storage {
    private static Map<String, List<Fruit>> fruits = new HashMap<>();

    public static Map<String, List<Fruit>> getFruits() {
        return fruits;
    }

    public static boolean addFruit(Fruit fruit) {
        if (!fruits.containsKey(fruit.getType())) {
            fruits.put(fruit.getType(), new ArrayList<>());
        }
        fruits.get(fruit.getType()).add(fruit);
        return true;
    }

    public static boolean removeFruit(Fruit fruit) {
        if (fruits.containsKey(fruit.getType()) && !fruits.get(fruit.getType()).isEmpty()) {
            fruits.get(fruit.getType()).remove(fruit);
        } else {
            throw new NoSuchElementException("There is no " + fruit.getType());
        }
        return true;
    }

    public static Map<String, Integer> currentAmountOfEachTypeOfFruit() {
        Map<String, Integer> output = new HashMap<>();
        for (Map.Entry<String, List<Fruit>> entry : fruits.entrySet()) {
            output.put(entry.getKey(), entry.getValue().size());
        }
        return output;
    }

    public static void clear() {
        fruits = new HashMap<>();
    }
}
