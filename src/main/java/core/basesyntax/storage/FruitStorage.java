package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static final Map<Fruit, Integer> fruitStorage = new HashMap<>();

    public static Map<Fruit, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
