package core.basesyntax.service;

import core.basesyntax.model.FruitBatch;
import java.util.HashMap;
import java.util.Map;

public class DataFormatter {

    public Map<String, Integer> formatData(Map<FruitBatch, Integer> fruits) {
        Map<String, Integer> formattedData = new HashMap<>();
        for (Map.Entry<FruitBatch, Integer> entry : fruits.entrySet()) {
            String fruitType = entry.getKey().getFruitType();
            int quantity = entry.getValue();
            if (formattedData.containsKey(fruitType)) {
                formattedData.put(fruitType,
                        formattedData.get(fruitType) + quantity);
            } else {
                formattedData.put(fruitType, quantity);
            }
        }
        return formattedData;
    }
}
