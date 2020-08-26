package core.basesyntax;

import java.util.LinkedHashMap;
import java.util.Map;

public class FruitStoreDao {
    private static final Map<InputDataModel, Integer> fruitsInStore = new LinkedHashMap<>();

    public void addFruitProduct(InputDataModel fruit, int amount) {
        if (fruitsInStore.containsKey(fruit)) {
            fruitsInStore.compute(fruit, (f, a) -> a + amount);
            return;
        }
        fruitsInStore.put(fruit, amount);
    }

    public boolean changeAmountOfFruitProduct(InputDataModel fruit, int quantity) {
        if (fruitsInStore.containsKey(fruit)) {
            fruitsInStore.compute(fruit, (f, a) -> a - quantity);
            return true;
        }
        return false;
    }

    public void removeFruitProduct(InputDataModel fruit) {
        fruitsInStore.remove(fruit);
    }

    public Map<InputDataModel, Integer> getAllFruits() {
        return fruitsInStore;
    }

    public void throwAwayAllTheFruits() {
        fruitsInStore.clear();
    }
}
