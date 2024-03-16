package core.basesyntax.servise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> generateReport(Map<String, Integer> fruitStore) {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitStore.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
