package core.basesyntax.services.operations;

import java.util.HashMap;
import java.util.Map;

public class Supply implements Operable {

    @Override
    public boolean updateStorage(Map<String, Map<String, Integer>> store, String[] data) {
        String supplyingFruit = data[1];
        Integer availableFruitCount = Integer.parseInt(data[2]);
        String fruitExpirationDate = data[3];
        if (store.containsKey(supplyingFruit)) {
            Map<String, Integer> fruit = store.get(supplyingFruit);
            int newFruitCount = availableFruitCount;
            if (fruit.containsKey(fruitExpirationDate)) {
                newFruitCount += fruit.get(fruitExpirationDate);
            }
            fruit.put(fruitExpirationDate, newFruitCount);
        } else {
            Map<String, Integer> newMap = new HashMap<>();
            newMap.put(fruitExpirationDate, availableFruitCount);
            store.put(supplyingFruit, newMap);
        }
        return true;
    }
}
