package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<String, Integer> calculationMap = new HashMap<>();
    private Integer i; // storage1.i != storage2.i

    public Map<String, Integer> getCalculationMap() {
        return calculationMap;
    }

    public void setCalculationMap(Map<String, Integer> calculationMap) {
        Storage.calculationMap = calculationMap;
    }
}


