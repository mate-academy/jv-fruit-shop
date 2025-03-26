package core.basesyntax.report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport(Map<String, Integer> fruitStorage) {
        StringBuilder report = new StringBuilder("fruit,quantity" + LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            report.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
