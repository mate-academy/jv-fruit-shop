package core.basesyntax.report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_LINE_SEPARATOR = ",";

    @Override
    public String getReport(Map<String, Integer> fruitStorage) {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            report.append(entry.getKey()).append(REPORT_LINE_SEPARATOR)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
