package core.basesyntax.service.impl;

import core.basesyntax.service.Producer;
import java.util.Map;

public class ProduceMapReportService implements Producer {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String COMA = ",";

    @Override
    public String produceReport(Map<String, Integer> map) {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            report.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        return report.toString();
    }
}
