package core.basesyntax.service.impl;

import java.util.Map;

public class ReportGenerator {
    private static final String TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public String generateReport(Map<String, Integer> values) {
        StringBuilder builder = new StringBuilder(TITLE);
        builder.append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            builder.append(key).append(SEPARATOR)
                    .append(value)
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
