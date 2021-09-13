package core.basesyntax.services;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_REPORT = "fruit, quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<String, Integer> mapQuantityFruit) {
        StringBuilder builder = new StringBuilder();
        builder.append(TITLE_REPORT);
        for (Map.Entry<String, Integer> entry : mapQuantityFruit.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return builder.append(System.lineSeparator()).toString();
    }
}
