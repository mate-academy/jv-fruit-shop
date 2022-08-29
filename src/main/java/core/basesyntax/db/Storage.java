package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> fruitsAmount;

    Storage() {
        fruitsAmount = new HashMap<>();
    }

    Map<String, Integer> getFruitsAmount() {
        return fruitsAmount;
    }
}
