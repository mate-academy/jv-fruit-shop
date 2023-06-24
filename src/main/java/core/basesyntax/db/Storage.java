package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitStorge = new HashMap<>();

    public static Map<String, Integer> getFruitStorge() {
        return fruitStorge;
    }
}
