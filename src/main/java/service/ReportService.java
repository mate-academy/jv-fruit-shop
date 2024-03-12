package service;

import java.util.Map;

public interface ReportService {
    String generateReport(Map<String, Integer> processedData);
}
