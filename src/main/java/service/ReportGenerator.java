package service;

import java.util.Map;

public interface ReportGenerator {
    
    String generate(Map<String, Integer> storageData);
}
