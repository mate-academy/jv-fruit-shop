package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruitQuantities;

    public Storage() {
        this.fruitQuantities = new HashMap<>();
    }
}
