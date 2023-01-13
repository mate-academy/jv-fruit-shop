package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> fruitMap) {
        StringBuilder report = new StringBuilder("fruit,quantity");
        report.append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            report
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
