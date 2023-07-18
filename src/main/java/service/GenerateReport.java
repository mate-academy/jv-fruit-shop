package service;

import java.util.List;
import java.util.Map;

public interface GenerateReport {
    List<String> generateReport(Map<String,Integer> storage);
}
