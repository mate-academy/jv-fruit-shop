package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> quantities;

    public Storage() {
        this.quantities = new HashMap<>();
    }

    public void setQuantity(String fruit, int quantity) {
        quantities.put(fruit, quantity);
    }

    public void increaseQuantity(String fruit, int quantity) {
        quantities.put(fruit, quantities.getOrDefault(fruit, 0) + quantity);
    }

    public void decreaseQuantity(String fruit, int quantity) {
        quantities.put(fruit, quantities.getOrDefault(fruit, 0) - quantity);
    }

    public int getQuantity(String fruit) {
        return quantities.getOrDefault(fruit, 0);
    }
}
