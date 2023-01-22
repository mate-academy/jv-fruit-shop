package service.impl;

import java.util.Map;
import java.util.stream.Stream;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_REPORT = "fruit,quantity";
    private static final String SPLIT_COMMA = ",";

    @Override
    public String getReport(Map<String, Integer> data) {
        StringBuilder report = new StringBuilder(TITLE_REPORT).append(System.lineSeparator());
        Stream.of(data)
                .flatMap(c -> c.entrySet().stream())
                .forEach(r -> report.append(r.getKey())
                        .append(SPLIT_COMMA)
                        .append(r.getValue())
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
