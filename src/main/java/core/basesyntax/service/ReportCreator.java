package core.basesyntax.service;

import java.util.Map;

public class ReportCreator {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMMA = ",";

    public String createReport(Map<String, Integer> dataForReport) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : dataForReport.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
