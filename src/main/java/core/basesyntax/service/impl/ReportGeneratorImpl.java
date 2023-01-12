package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String generateReport(Map<String, Integer> map) {
        StringBuilder report = new StringBuilder().append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> storage : map.entrySet()) {
            report.append(storage.getKey())
                    .append(",")
                    .append(storage.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}

