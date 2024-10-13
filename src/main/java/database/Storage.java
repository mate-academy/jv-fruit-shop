package database;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> assortment = new HashMap<>();

    public static Map<String, Integer> getAssortment() {
        return assortment;
    }
}
