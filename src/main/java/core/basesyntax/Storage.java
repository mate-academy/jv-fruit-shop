package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruitQuantities;

    public Storage() {
        this.fruitQuantities = new HashMap<>();
    }

    public void addFruit(String fruit, int quantity) {
        int currentQuantity = fruitQuantities.getOrDefault(fruit, 0);
        fruitQuantities.put(fruit, currentQuantity + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        int currentQuantity = fruitQuantities.getOrDefault(fruit, 0);
        fruitQuantities.put(fruit, currentQuantity - quantity);
    }

    public Map<String, Integer> getFruitQuantities() {
        return fruitQuantities;
    }
}

