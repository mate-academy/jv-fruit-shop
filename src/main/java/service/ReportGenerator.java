package service;

import java.util.Map;

public interface ReportGenerator {
    String createReport(Map<String, Integer> transactionResultMap);
}
