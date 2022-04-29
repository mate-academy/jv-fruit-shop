package core.basesyntax.storage;

import core.basesyntax.models.Fruit;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<Fruit, Integer> storage = new HashMap<>();

    public void add(Fruit fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }

    public Integer get(Fruit fruit) {
        return storage.get(fruit);
    }

    public void displayStorage() {
        System.out.println(storage.entrySet());
    }
}
