package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> leftovers = new HashMap<>();

    public static Map<Fruit, Integer> getLeftovers() {
        return Collections.unmodifiableMap(leftovers);
    }

    public static Map<Fruit, Integer> getModifiableLeftovers() {
        return leftovers;
    }
}
