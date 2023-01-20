package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_TITLE = "fruit,quantity";

    @Override
    public List<String> createReport(Map<String, Integer> fruits) {
        List<String> report = new ArrayList<>();
        report.add(REPORT_TITLE);
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
