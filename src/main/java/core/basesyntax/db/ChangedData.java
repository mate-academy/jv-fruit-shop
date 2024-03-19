package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class ChangedData {
    private final Map<String, Integer> changedData = new HashMap<>();

    public Map<String, Integer> getChangedData() {
        return changedData;
    }
}
