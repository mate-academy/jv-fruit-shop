package core.basesyntax.serviceimpl;

import java.util.Map;

public class ReportGenerate {
    public String generateReport(Map<String, Integer> values) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit").append(",").append("quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            builder.append(key).append(",")
                    .append(value)
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
