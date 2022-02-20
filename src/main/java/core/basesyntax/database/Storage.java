package core.basesyntax.database;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> fruitsDataBase = new HashMap<>();

    public static Map<Fruit, Integer> getFruitsDataBase() {
        return fruitsDataBase;
    }
}
