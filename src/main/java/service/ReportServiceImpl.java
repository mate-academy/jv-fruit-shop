package service;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity\n";

    @Override
    public String generateReport(Map<String, Integer> processedData) {
        StringBuilder report = new StringBuilder(TITLE);
        for (String fruit : processedData.keySet()) {
            report.append(fruit).append(",").append(processedData.get(fruit)).append("\n");
        }
        return report.toString();
    }
}
