package core.basesyntax.service.impl;

import core.basesyntax.service.Producer;
import java.util.Map;

public class ProduceMapReportService implements Producer {
    private static final String NEW_LINE = System.lineSeparator();

    @Override
    public String producReport(Map<String, Integer> map) {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        return report.toString();
    }
}
