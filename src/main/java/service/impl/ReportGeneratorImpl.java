package service.impl;

import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey()).append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
