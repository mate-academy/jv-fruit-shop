package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<String, Integer> inventory) {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        inventory.forEach((fruit, quantity) ->
                report.append(fruit).append(",").append(quantity).append("\n")
        );
        return report.toString();
    }
}
