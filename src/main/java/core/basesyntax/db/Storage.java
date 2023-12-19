package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> stock = new HashMap<>();

    public static Map<String, Integer> getStock() {
        return stock;
    }
}
