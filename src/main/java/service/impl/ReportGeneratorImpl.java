package service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";

    public List<String> generateReport(Map<String, Integer> reportData) {
        List<String> report = reportData.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        report.add(0, REPORT_HEADER); // Add header line
        return report;
    }
}
