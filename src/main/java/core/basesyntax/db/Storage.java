package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> mapOfFruits = new HashMap<>();

    public Map<String, Integer> getMapOfFruits() {
        return mapOfFruits;
    }
}
