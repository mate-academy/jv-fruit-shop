package core.basesyntax.serviceimpl;

import java.util.Map;

public class ReportGenerator {
    private static final String COLUMN_1 = "fruit";
    private static final String COLUMN_2 = "quantity";
    private static final String SEPARATOR = ",";

    public String generateReport(Map<String, Integer> values) {
        StringBuilder builder = new StringBuilder();
        builder.append(COLUMN_1).append(SEPARATOR).append(COLUMN_2).append(System.lineSeparator());
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
