package core.basesyntax.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataToMapParser {
    public Map<String, Map<String, Integer>> parseData(List<FruitDto> fruits,
                                                       Map<String, FruitOperations> operations) {
        Map<String, Map<String, Integer>> storage = new HashMap<>();
        for (FruitDto data : fruits) {
            if (operations.containsKey(data.getType())) {
                operations.get(data.getType()).operations(storage, data);
            }
        }
        return storage;
    }
}
