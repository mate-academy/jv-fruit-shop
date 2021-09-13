package core.basesyntax.services;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<String, Integer> mapQuantityFruit, String titleReport) {
        StringBuilder builder = new StringBuilder();
        builder.append(titleReport);
        for (Map.Entry<String, Integer> entry : mapQuantityFruit.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }
        return builder.append(System.lineSeparator()).toString();
    }
}
