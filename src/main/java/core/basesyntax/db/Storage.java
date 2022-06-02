package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruitsStorage = new HashMap<>();

    public Map<String, Integer> getFruitsStorage() {
        return fruitsStorage;
    }

}
