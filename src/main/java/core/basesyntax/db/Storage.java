package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitsTransactions = new HashMap<>();

    public Map<String, Integer> getFruitsTransactions() {
        return this.fruitsTransactions;
    }
}
