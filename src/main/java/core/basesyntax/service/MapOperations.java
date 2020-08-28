package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {
    private Map<String, core.basesyntax.service.Operational> mapOperations = new HashMap<>();

    public void addOperation(String key, core.basesyntax.service.Operational operation) {
        mapOperations.put(key, operation);
    }

    public core.basesyntax.service.Operational getOperation(String key) {
        return mapOperations.get(key);
    }
}
