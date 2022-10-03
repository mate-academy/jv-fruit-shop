package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    static {
        storage = new HashMap<>();
    }

    public static final Map<Fruit, Integer> storage;
}
