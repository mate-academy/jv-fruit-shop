package core.basesyntax.impl;

import core.basesyntax.service.CreateReport;
import java.util.Map;

public class CreateReportImpl implements CreateReport {
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            builder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append("\n");
        }
        return builder.toString();
    }
}
