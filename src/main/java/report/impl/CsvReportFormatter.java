package report.impl;

import java.util.Map;
import report.ReportFormatter;

public class CsvReportFormatter implements ReportFormatter {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String format(Map<String, Integer> storage) {
        StringBuilder builder = new StringBuilder();
        builder.append(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            builder.append(fruit).append(SEPARATOR).append(quantity).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
