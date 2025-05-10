package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> products;

    public Storage() {
        products = new HashMap<>();
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

}
