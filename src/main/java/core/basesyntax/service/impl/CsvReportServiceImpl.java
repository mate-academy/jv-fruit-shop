package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class CsvReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SPLITTER = ",";

    @Override
    public String createReport(Map<String, Integer> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEADER);
        data.forEach((name, quantity) -> {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(name);
            stringBuilder.append(SPLITTER);
            stringBuilder.append(quantity);
        });
        return stringBuilder.toString();
    }
}
