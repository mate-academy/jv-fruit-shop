package core.basesyntax.service.impl;

import core.basesyntax.service.ReportMakerService;
import java.util.Map;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String TABLE_HEADER = "fruit, quantity";
    private static final char TABLE_SEPARATOR = ',';

    @Override
    public String generateReport(Map<String, Integer> data) {
        StringBuilder report = new StringBuilder();
        report.append(TABLE_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> pair : data.entrySet()) {
            report.append(pair.getKey())
                .append(TABLE_SEPARATOR)
                .append(pair.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
