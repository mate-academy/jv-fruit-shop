package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class SupplyAndReturnOperation implements FruitOperations {
    @Override
    public boolean operations(Map<String, Map<String, Integer>> storage, FruitDto fruits) {
        String currentFruit = fruits.getFruit();
        Integer currentQuantity = fruits.getQuantity();
        String currentDate = fruits.getDate();
        if (storage.containsKey(currentFruit)) {
            Map<String, Integer> fruit = storage.get(currentFruit);
            Integer newFruitCount = currentQuantity;
            if (fruit.containsKey(currentDate)) {
                newFruitCount += fruit.get(currentDate);
            }
            fruit.put(currentDate, newFruitCount);
        } else {
            Map<String, Integer> newMap = new HashMap<>();
            newMap.put(currentDate, currentQuantity);
            storage.put(currentFruit, newMap);
        }
        return true;
    }
}
