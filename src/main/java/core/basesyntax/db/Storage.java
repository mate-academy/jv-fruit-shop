package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruits = new HashMap<>();

    public Map<String, Integer> getFruitsTransactions() {
        return this.fruits;
    }
}
