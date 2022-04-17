package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(Map<String, Integer> fruitStorage) {
        StringBuilder stringBuilder = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            stringBuilder
                    .append(LINE_SEPARATOR)
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }

        return stringBuilder.toString();

    }
}
