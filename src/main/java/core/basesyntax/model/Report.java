package core.basesyntax.model;

import java.util.Map;

public class Report {
    private Map<String, Integer> fruitQuantityMap;

    public Report(Map<String, Integer> fruitQuantityMap) {
        this.fruitQuantityMap = fruitQuantityMap;
    }

    public Map<String, Integer> getFruitQuantityMap() {
        return fruitQuantityMap;
    }
}
