package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append("\n")
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
