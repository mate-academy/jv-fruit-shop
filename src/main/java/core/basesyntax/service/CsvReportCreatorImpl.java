package core.basesyntax.service;

import java.util.Map;

public class CsvReportCreatorImpl implements ReportCreator {
    @Override
    public String createReport(Map<String, Integer> data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry m: data.entrySet()) {
            stringBuilder.append(m.getKey())
                    .append(",")
                    .append(m.getValue())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
