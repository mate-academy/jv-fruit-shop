package report.impl;

import java.util.Map;
import report.ReportFormatter;

public class CsvReportFormatter implements ReportFormatter {
    private static final String First_LINE = "fruit,quantity\n";
    private static final String SEPARATION = ",";
    private static final String NEXT_LINE = "\n";

    @Override
    public String format(Map<String, Integer> storage) {
        StringBuilder builder = new StringBuilder();
        builder.append(First_LINE);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            builder.append(fruit).append(SEPARATION).append(quantity).append(NEXT_LINE);
        }
        return builder.toString();
    }
}
