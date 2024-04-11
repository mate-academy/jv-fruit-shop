package service.impl;

import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements service.ReportService {
    @Override
    public List<String> generateReport(Map<String, Integer> fruitCounts) {
        List<String> report = new java.util.ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitCounts.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}

