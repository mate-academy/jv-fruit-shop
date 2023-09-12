package service.impl;

import db.Warehouse;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TOP_OF_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder().append(TOP_OF_REPORT);
        for (Map.Entry<String, Integer> line : Warehouse.STORAGE.entrySet()) {
            report.append(System.lineSeparator()).append(line.getKey())
                    .append(COMMA).append(line.getValue());
        }
        return report.toString();
    }
}
