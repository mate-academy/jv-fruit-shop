package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String makeReport(Map<String, Integer> data) {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return builder.toString();
    }
}
