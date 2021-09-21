package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> fruitsStorage = new HashMap<>();

    public Map<Fruit, Integer> getAllData() {
        return fruitsStorage;
    }
}
