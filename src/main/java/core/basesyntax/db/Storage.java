package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    public static final Map<Fruit, Integer> storage = new HashMap<>();

    public static Set<Map.Entry<Fruit, Integer>> getAll() {
        return storage.entrySet();
    }
}
