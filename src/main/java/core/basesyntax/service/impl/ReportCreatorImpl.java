package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String createReport(Map<String, Integer> fruits) {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (var entry : fruits.entrySet()) {
            if (fruits.get(entry.getKey()) < 0) {
                throw new RuntimeException("The balance can`t be negative: " + entry.getValue());
            }
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
