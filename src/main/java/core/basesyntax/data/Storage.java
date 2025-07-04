package core.basesyntax.data;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> assortment = new HashMap<>();

    public static Map<String, Integer> getAssortment() {
        return assortment;
    }

    public static void setAssortment(Map<String, Integer> value) {
        assortment = value;
    }
}
