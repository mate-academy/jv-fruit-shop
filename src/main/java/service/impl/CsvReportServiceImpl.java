package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class CsvReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String COMMA_CHARACTER = ",";

    @Override
    public String createReport(Map<String, Integer> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEADER);
        for (Map.Entry<String, Integer> storage : Storage.fruitsStorage.entrySet()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(storage.getKey());
            stringBuilder.append(COMMA_CHARACTER);
            stringBuilder.append(storage.getValue());
        }
        return String.valueOf(stringBuilder);
    }
}
