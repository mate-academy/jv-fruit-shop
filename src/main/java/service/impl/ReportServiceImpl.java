package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String DEFAULT_TITLE = "fruit,quantity\n";
    private static final String COMA = ",";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(DEFAULT_TITLE);
        for (Map.Entry<String, Integer> entry: Storage.storage.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
