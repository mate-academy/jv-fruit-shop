package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruitQuantityMap;

    public Storage() {
        fruitQuantityMap = new HashMap<>();
    }

    public Map<String, Integer> getFruitQuantityMap() {
        return fruitQuantityMap;
    }
}
