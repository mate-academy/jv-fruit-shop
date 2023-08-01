package core.basesyntax.db;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FruitsStorage {
    private final Map<String, BigDecimal> fruitsStorage = new HashMap<>();

    public Map<String, BigDecimal> getFruitsStorage() {
        return fruitsStorage;
    }
}
