package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class DB {
    private static final Map<String, Integer> fruitsDB = new HashMap<>();

    public static Map<String, Integer> getFruitsDB() {
        return fruitsDB;
    }
}
