package core.basesyntax.impl;

import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService<String> {

    @Override
    public List<String> createReport(Map<String, Integer> map) {
        List<String> report = new ArrayList<>();
        for (String key : map.keySet()) {
            int value = map.get(key);
            String element = key + "," + value;
            report.add(element);
        }
        return report;
    }
}
