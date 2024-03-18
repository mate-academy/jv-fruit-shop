package core.basesyntax.serviseimpl;

import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public List<String> generateReport(Map<String, Integer> fruitStore) {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        for (Map.Entry<String, Integer> entry : fruitStore.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
