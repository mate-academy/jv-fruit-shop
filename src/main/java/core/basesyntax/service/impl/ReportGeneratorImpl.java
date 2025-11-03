package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String getReport(Map<String, Integer> fruitData) {
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(LINE_SEPARATOR);

        //noinspection SingleSpaceSeparator
        for (Map.Entry<String, Integer> entry : fruitData.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
