package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements service.ReportService {
    private static final String CATEGORIES = "fruit,quantity";

    @Override
    public List<String> generateReport(Map<String, Integer> fruitCounts) {
        List<String> report = new ArrayList<>();
        report.add(CATEGORIES);
        for (Map.Entry<String, Integer> entry : fruitCounts.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}

