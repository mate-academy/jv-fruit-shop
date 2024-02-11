package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<String, Integer> fruitsMap) {
        StringBuilder builder = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruitsMap.entrySet()) {
            builder.append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
