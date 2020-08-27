package core.basesyntax;

import core.basesyntax.model.InputDataModel;
import java.util.LinkedHashMap;
import java.util.Map;

public class Storage {
    private static final Map<InputDataModel, Integer> fruitsInStore = new LinkedHashMap<>();

    public void addFruitProduct(InputDataModel fruit, int amount) {
        fruitsInStore.merge(fruit, amount, Integer::sum);
    }

    public boolean changeAmountOfFruitProduct(InputDataModel fruit, int quantity) {
        if (fruitsInStore.containsKey(fruit)) {
            fruitsInStore.merge(fruit, quantity, (f, a) -> f - a);
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
