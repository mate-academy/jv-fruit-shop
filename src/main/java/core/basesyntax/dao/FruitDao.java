package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class FruitDao {
    private static final Map<String, Integer> fruitsStorage = new HashMap<>();

    public static Map<String, Integer> getFruitsStorage() {
        return fruitsStorage;
    }
}
