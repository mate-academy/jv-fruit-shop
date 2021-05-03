package dbimitation;

import fruitsassortment.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> FRUIT_MAP = new HashMap<>();

    public static Map<Fruit, Integer> getFruits() {
        return FRUIT_MAP;
    }
}
