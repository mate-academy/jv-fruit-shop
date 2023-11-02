package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_COLUMN_NAME = "fruit";
    private static final String COMMA_SEPARATOR = ",";
    private static final String REPORT_COLUMN_QUANTITY = "quantity";

    @Override
    public String generateReport(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_COLUMN_NAME).append(COMMA_SEPARATOR)
                .append(REPORT_COLUMN_QUANTITY).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            builder.append(key).append(COMMA_SEPARATOR)
                    .append(value).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
