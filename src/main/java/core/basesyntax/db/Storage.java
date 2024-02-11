package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruitsTransactions = new HashMap<>();

    public Map<String, Integer> getFruitsTransactions() {
        return fruitsTransactions;
    }

    public void setFruitsTransactions(Map<String, Integer> fruitsTransactions) {
        this.fruitsTransactions = fruitsTransactions;
    }
}
