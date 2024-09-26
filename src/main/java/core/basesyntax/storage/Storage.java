package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
