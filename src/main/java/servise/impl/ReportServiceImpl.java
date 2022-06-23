package servise.impl;

import db.Storage;
import java.util.Map;
import servise.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA_DELIMITER = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> record : Storage.items.entrySet()) {
            report.append(System.lineSeparator())
                    .append(record.getKey())
                    .append(COMMA_DELIMITER)
                    .append(record.getValue());
        }
        return report.toString();
    }
}
