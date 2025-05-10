package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> changedData = new HashMap<>();

    public Map<String, Integer> getData() {
        return changedData;
    }
}
