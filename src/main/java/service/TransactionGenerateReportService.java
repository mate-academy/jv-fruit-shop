package service;

import java.util.Map;

public interface TransactionGenerateReportService {
    String generateReport(Map<String, Integer> fruitsCount);
}
