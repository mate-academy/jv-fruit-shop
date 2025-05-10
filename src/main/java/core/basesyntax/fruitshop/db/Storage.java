package core.basesyntax.fruitshop.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Storage instance = new Storage();
    private final Map<String, Integer> fruitStorage = new HashMap<>();

    private Storage() {

    }

    public static Storage getInstance() {
        return instance;
    }

    public Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
