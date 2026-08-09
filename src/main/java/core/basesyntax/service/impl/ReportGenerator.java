package core.basesyntax.service.impl;

import core.basesyntax.service.IReportGenerator;
import java.util.Map;

public class ReportGenerator implements IReportGenerator {

    @Override
    public String generateReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
