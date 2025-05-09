package core.basesyntax;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> fruits) {
        if (fruits.isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        for (Map.Entry<String, Integer> tempMap : fruits.entrySet()) {
            if (tempMap.getValue() < 0) {
                throw new RuntimeException("Quantity can not be less than 0!");
            }
        }
        String report = fruits.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue().toString())
                .collect(Collectors.joining("\n"));
        return "Fruit,quantity\n" + report;
    }
}
