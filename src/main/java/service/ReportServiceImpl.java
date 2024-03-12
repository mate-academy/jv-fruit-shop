package service;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String generateReport(Map<String, Integer> processedData) {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        for (String fruit : processedData.keySet()) {
            report.append(fruit).append(",").append(processedData.get(fruit)).append("\n");
        }
        return report.toString();
    }
}
