package Storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage instance = new Storage();
    private Map<String, Integer> fruitStorage = new HashMap<>();

    public Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }

    public static Storage getInstance() {
        return instance;
    }
    
}
