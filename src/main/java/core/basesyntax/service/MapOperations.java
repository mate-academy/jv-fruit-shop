package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {
    private Map<String, Operational> mapOperations = new HashMap<>();

    public void addOperation(String key, Operational operation) {
        mapOperations.put(key, operation);
    }

    public Operational getOperation(String key) {
        return mapOperations.get(key);
    }

    public int size() {
        return mapOperations.size();
    }
}
