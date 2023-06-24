package service.impl;

import db.Storage;
import java.util.stream.Stream;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_REPORT = "fruit,quantity";
    private static final String SPLIT_COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(TITLE_REPORT).append(System.lineSeparator());
        Stream.of(Storage.fruits)
                .flatMap(c -> c.entrySet().stream())
                .forEach(r -> report.append(r.getKey())
                        .append(SPLIT_COMMA)
                        .append(r.getValue())
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
