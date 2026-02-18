package core.basesyntax;

import java.util.*;

public class ReportGeneratorImpl implements ReportGenerator{

    @Override
    public List<String> getReport(Map<String, Integer> storage) {
        List<String> report = new ArrayList<>();
        report.add("fruit, quantity");
        for(Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.add(entry.getKey() + ", " + entry.getValue());
        }
        return report;
    }
}
