package service.impl;

import db.Storage;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMNS_TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder summaryStringReport = new StringBuilder(COLUMNS_TITLE);
        String stringReport = Storage.FRUITS.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .sorted()
                .collect(Collectors.joining(LINE_SEPARATOR));
        return summaryStringReport.append(LINE_SEPARATOR).append(stringReport).toString();
    }
}
