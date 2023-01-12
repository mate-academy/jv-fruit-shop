package core.basesyntax.db;

import core.basesyntax.db.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> storage = new HashMap<>();

    public static void put(FruitTransaction fruit, Integer quantity) {
        storage.put(fruit.getFruit(), quantity);
    }

    public static Integer getFruit(FruitTransaction fruit) {
        return storage.get(fruit);
    }

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
