package service;

import java.util.Map;

public interface CreateReportService {
    String generateReport(Map<String, Integer> processedData);

}
