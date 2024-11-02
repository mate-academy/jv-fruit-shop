package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> FRUIT_STORAGE = new HashMap<>();

    public Map<String, Integer> getFruitStorage() {
        return FRUIT_STORAGE;
    }
}
