package core.basesyntax.impl;

import core.basesyntax.service.CreateReport;
import java.util.Map;

public class CreateReportImpl implements CreateReport {
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            builder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        System.out.println(builder);
        return builder.toString();
    }
}
