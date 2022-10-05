package core.basesyntax.service;

import java.util.Map;

public class CsvReportCreatorImpl implements ReportCreator {
    @Override
    public String createReport(Map<String, Integer> data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry: data.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
