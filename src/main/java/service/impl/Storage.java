package service.impl;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> report = new HashMap<>();

    public static Map<Fruit, Integer> getReport() {
        return report;
    }
}
