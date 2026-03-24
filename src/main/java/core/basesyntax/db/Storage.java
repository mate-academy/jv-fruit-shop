package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage implements core.basesyntax.db.StorageInterface {
    private final Map<String, Integer> fruitsInStock = new HashMap<>();

    @Override
    public void put(String fruitName, int quantity) {
        fruitsInStock.put(fruitName, quantity);
    }

    @Override
    public int getQuantity(String fruitName) {
        return fruitsInStock.getOrDefault(fruitName, 0);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Map.copyOf(fruitsInStock);
    }
}
