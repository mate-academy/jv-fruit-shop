package core.basesyntax.report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> fruitStorage) {
        StringBuilder report = new StringBuilder("fruit,quantity" + "\n");
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            report.append("\n").append(entry.getKey()).append(",")
                    .append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
