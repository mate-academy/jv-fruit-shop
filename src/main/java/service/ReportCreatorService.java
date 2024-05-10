package service;

import java.util.List;
import java.util.Map;

public interface ReportCreatorService {
    List<String> getReport(Map<String, Integer> statistic);
}
