package service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> generateReport(Map<String, Integer> reportData) {
        return reportData.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
    }
}
