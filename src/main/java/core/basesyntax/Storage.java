package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruitQuantities;

    public Storage() {
        this.fruitQuantities = new HashMap<>();
    }

    public void addFruit(String fruit, int quantity) {
        fruitQuantities.merge(fruit, quantity, Integer::sum);
    }

    public void removeFruit(String fruit, int quantity) {
        fruitQuantities.merge(fruit, -quantity, Integer::sum);
    }

    public Map<String, Integer> getFruitQuantities() {
        return fruitQuantities;
    }
}
