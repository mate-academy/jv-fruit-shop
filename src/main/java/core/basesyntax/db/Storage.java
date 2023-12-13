package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> reportMap = new HashMap<>();

    public void addToReport(String fruit, int quantity) {
        reportMap.put(fruit, quantity);
    }

    public Integer getQuantity(String fruit) {
        return reportMap.get(fruit);
    }

    public Map<String, Integer> getReportMap() {
        return reportMap;
    }
}
