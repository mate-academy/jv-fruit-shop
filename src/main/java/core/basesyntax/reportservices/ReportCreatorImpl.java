package core.basesyntax.reportservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public List<String> report(Map<String, Integer> transactions) {
        List<String> report = new ArrayList<>();
        report.add("fruit, quantity");
        for (Map.Entry<String, Integer> entry : transactions.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
