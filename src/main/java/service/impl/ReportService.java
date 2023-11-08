package service.impl;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<String> makeReport(Map<String, Integer> report);
}
