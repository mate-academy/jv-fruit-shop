package core.basesyntax.services.operations;

import core.basesyntax.services.FruitDto;
import java.util.HashMap;
import java.util.Map;

public class SupplyOperation implements Operable {

    @Override
    public boolean updateStorage(Map<String, Map<String, Integer>> store, FruitDto dto) {
        String supplyingFruit = dto.getFruitName();
        Integer availableFruitCount = dto.getCount();
        String fruitExpirationDate = dto.getData();
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
