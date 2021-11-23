package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Fruit, Integer> dataBase = new HashMap<>();

    public static Map<Fruit, Integer> getDataBase() {
        return dataBase;
    }
}
