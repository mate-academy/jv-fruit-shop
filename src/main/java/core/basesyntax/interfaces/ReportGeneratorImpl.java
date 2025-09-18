package core.basesyntax.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public List<String> generate(Map<String, Integer> stock) {
        List<String> report = new ArrayList<>();
        report.add("fruit, quantity");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
