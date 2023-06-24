package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport(Map<String, Integer> fruits) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.append(String.format("%s,%d%s", entry.getKey(),
                    entry.getValue(), System.lineSeparator()));
        }
        return report.toString();
    }
}
