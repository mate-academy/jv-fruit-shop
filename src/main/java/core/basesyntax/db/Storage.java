package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Fruit, Integer> fruitStore = new HashMap<>();

    public static Map<Fruit, Integer> getFruitStore() {
        return fruitStore;
    }

    public static void setFruitStore(Map<Fruit, Integer> fruitStore) {
        Storage.fruitStore = fruitStore;
    }
}



