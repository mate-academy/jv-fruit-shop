package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> data = new HashMap<>();

    public void add(String fruit, int quantity) {
        checkQuantity(quantity);
        data.merge(fruit, quantity, Integer::sum);
    }

    public void subtract(String fruit, int quantity) {
        checkQuantity(quantity);

        if (data.containsKey(fruit)) {
            int currentValue = data.get(fruit);
            int newValue = currentValue - quantity;
            checkQuantity(newValue);
            data.put(fruit, newValue);
        } else {
            throw new RuntimeException("The shop doesn't have this fruit");
        }
    }

    public Map<String, Integer> getData() {
        return data;
    }

    private void checkQuantity(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Number of fruits can't be less than 0");
        }
    }
}
