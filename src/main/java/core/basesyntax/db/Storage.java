package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> fruitStorage = new HashMap<>();

    public static Map<Fruit, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
