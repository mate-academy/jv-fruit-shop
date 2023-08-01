package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(Map<String, Integer> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit")
                .append(COMMA_SEPARATOR)
                .append("quantity")
                .append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA_SEPARATOR)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
