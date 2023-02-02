package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportsServiceImpl implements ReportService {
    @Override
    public String createReport(Map<String,Integer> fruits) {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> f : fruits.entrySet()) {
            report.append(f.getKey()).append(",")
                    .append(f.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
