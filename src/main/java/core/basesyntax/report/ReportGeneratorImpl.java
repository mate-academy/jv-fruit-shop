package core.basesyntax.report;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> generateReport(Map<Fruit, Integer> storage) {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            sb.append(entry.getKey().getFruitName()).append(',').append(entry.getValue());
            report.add(sb.toString());
            sb.replace(0, sb.length(), "");
        }
        return report;
    }
}
