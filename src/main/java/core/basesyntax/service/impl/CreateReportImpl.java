package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReport;
import java.util.Map;

public class CreateReportImpl implements CreateReport {
    @Override
    public String getReport(Map<String, Integer> map) {
        StringBuilder report = new StringBuilder("fruit,quantity");
        report.append(System.lineSeparator());
        for (Map.Entry entry: map.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }

}
