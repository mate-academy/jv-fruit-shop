package core.basesyntax.services;

import core.basesyntax.services.operations.Operable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataToMapParser {
    public Map<String, Map<String, Integer>> parseData(List<String[]> lines,
                                                       Map<String, Operable> operations) {
        Map<String, Map<String, Integer>> fruitStore = new HashMap<>();
        for (String[] line : lines) {
            if (operations.containsKey(line[0])) {
                operations.get(line[0]).updateStorage(fruitStore, line);
            }
        }
        return fruitStore;
    }
}
