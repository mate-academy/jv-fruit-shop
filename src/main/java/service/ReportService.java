package service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<String> createReport(Map<String,Integer> storageMap);
}
