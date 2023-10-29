package core.basesyntax.service;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public String createReport(Map<String, Integer> report) {
        StringBuilder reportAsString = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : Storage.REPORT.entrySet()) {
            reportAsString.append(System.getProperty("line.separator"))
                    .append(entry.getKey()).append(SEPARATOR).append(entry.getValue());
        }
        return reportAsString.toString();
    }
}
