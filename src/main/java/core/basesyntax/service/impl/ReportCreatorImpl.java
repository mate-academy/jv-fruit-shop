package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String createReport(Map<String, Integer> fruitReport) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : fruitReport.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            reportBuilder.append(fruit).append(",").append(quantity).append("\n");
        }
        return reportBuilder.toString();
    }
}
