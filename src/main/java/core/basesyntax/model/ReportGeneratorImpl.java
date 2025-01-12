package core.basesyntax.model;

import java.util.Map;
import java.util.StringJoiner;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringJoiner report = new StringJoiner("\n");
        report.add("fruit,quantity");

        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }

        return report.toString();
    }
}
