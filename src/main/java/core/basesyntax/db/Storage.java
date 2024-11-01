package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruitShopStorage = new HashMap<>();

    public Map<String, Integer> getFruits() {
        return fruitShopStorage;
    }
}
