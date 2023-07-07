package core.shop.service.impl;

import core.shop.db.Storage;
import core.shop.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMA_SEPARATOR = ",";

    @Override
    public String generateReport() {
        Map<String, Integer> records = Storage.fruits;
        StringBuilder record = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<String, Integer> entry : records.entrySet()) {
            record.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMA_SEPARATOR)
                    .append(entry.getValue());
        }
        return record.toString();
    }
}
