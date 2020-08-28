package core.basesyntax.services;

import core.basesyntax.services.operations.Operable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataToMapParser {
    public Map<String, Map<String, Integer>> parseData(List<FruitDto> lines,
                                                       Map<String, Operable> operations) {
        Map<String, Map<String, Integer>> fruitStore = new HashMap<>();
        for (FruitDto dto : lines) {
            if (operations.containsKey(dto.getOperation())) {
                operations.get(dto.getOperation()).updateStorage(fruitStore, dto);
            }
        }
        return fruitStore;
    }
}
