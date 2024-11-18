package core.basesyntax.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    public List<String> generateReport(Map<String, Integer> inventory) {
        List<String> result = new ArrayList<>();
        result.add("fruit,quantity");
        for (String key : inventory.keySet()) {
            result.add(key + "," + inventory.get(key));
        }
        return result;
    }
}
