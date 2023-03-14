package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String OUTPUT_HEADER = "fruit,quantity";
    private static final String NEW_LINE = "\n";
    private static final String SEPARATOR = ",";

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OUTPUT_HEADER);
        stringBuilder.append(NEW_LINE);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(SEPARATOR).append(entry.getValue());
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
