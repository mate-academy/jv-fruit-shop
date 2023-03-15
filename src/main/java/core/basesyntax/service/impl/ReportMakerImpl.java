package core.basesyntax.service.impl;

import core.basesyntax.service.ReportMaker;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    private static final String TABLE_HEADER = "fruit, quantity";
    private static final char TABLE_SEPARATOR = ',';

    @Override
    public String generateReport(Map<String, Integer> calculations) {
        StringBuilder report = new StringBuilder();
        report.append(TABLE_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> calculation : calculations.entrySet()) {
            report.append(calculation.getKey())
                .append(TABLE_SEPARATOR)
                .append(calculation.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
