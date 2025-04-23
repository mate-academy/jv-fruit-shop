package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private Map<String, Integer> fruits = new HashMap<>();

    public Map<String, Integer> getFruits() {
        return fruits;
    }
}
