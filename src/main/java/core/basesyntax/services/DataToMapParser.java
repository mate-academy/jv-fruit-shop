package core.basesyntax.services;

import core.basesyntax.services.operations.Operable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataToMapParser {
    public Map<String, Map<String, Integer>> parseData(List<FruitDto> lines,
                                                       Map<String, Operable> operations) {
        Map<String, Map<String, Integer>> fruitStore = new HashMap<>();
        lines.stream()
                .filter(dto -> operations.containsKey(dto.getOperation()))
                .forEach(dto -> operations.get(dto.getOperation()).updateStorage(fruitStore, dto));
        return fruitStore;
    }
}
