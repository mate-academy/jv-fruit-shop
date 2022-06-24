package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    private final Map<String, Integer> shopStorage;

    private Storage(Map<String, Integer> mapOfKeys) {
        shopStorage = mapOfKeys;
    }

    public static Storage ofKeys(Set<String> keys) {
        Map<String, Integer> mapOfKeys = new HashMap<>();
        keys.forEach(s -> mapOfKeys.put(s, 0));
        return new Storage(mapOfKeys);
    }

    public Map<String, Integer> getShopStorage() {
        return shopStorage;
    }
}
