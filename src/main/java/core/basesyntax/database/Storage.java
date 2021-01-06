package core.basesyntax.database;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    static Map<Fruit, Long> storage;

    static {
        storage = new HashMap<>();
    }

    public static Map<Fruit, Long> getStorage(){
        return storage;
    }
}
