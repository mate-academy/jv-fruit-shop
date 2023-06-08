package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String HEADING = "fruit,quantity";

    public List<String> generateReport(Map<String, Integer> fruitBalance) {
        List<String> report = new ArrayList<>();

        report.add(HEADING);

        for (Map.Entry<String, Integer> entry : fruitBalance.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            report.add(fruit + SEPARATOR + quantity);
        }

        return report;
    }
}
