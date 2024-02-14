package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public List<String> createReport(Map<String, Integer> data) {
        List<String> report = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}
