package core.basesyntax.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    public List<String> generateReport(Map<String, Integer> inventory) {
        if (validateInputMap(inventory)) {
            throw new IllegalArgumentException(
                    "Error while generate report. Map cannot be null or empty!");
        }
        List<String> result = new ArrayList<>();
        result.add("fruit,quantity");
        for (String key : inventory.keySet()) {
            result.add(key + "," + inventory.get(key));
        }
        inventory.forEach((key, value) -> result.add(key + "," + value));
        return result;
    }

    private boolean validateInputMap(Map<String, Integer> inventory) {
        return inventory != null && !inventory.isEmpty();
    }
}
