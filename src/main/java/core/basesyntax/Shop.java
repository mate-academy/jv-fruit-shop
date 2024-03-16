package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Shop {

    private final Map<String, Integer> fruitsQuantityMap;

    public Shop() {
        fruitsQuantityMap = new HashMap<>();
    }

    public Set<String> getFruits() {
        return fruitsQuantityMap.keySet();
    }

    public void supplyFruits(String fruitName, int quantity) {
        fruitsQuantityMap.compute(fruitName, (key, oldQuantity) ->
                oldQuantity == null
                        ? quantity
                        : oldQuantity + quantity);
    }

    public int getFruitsQuantity(String fruitName) {
        return fruitsQuantityMap.get(fruitName);
    }
}
