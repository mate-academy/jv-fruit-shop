package service.impl;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<Fruit, Integer> report = new HashMap<>();

    public Map<Fruit, Integer> getReport() {
        return report;
    }
}
