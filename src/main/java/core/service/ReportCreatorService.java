package core.service;

import java.util.Map;

public interface ReportCreatorService {
    String createReport(Map<String, Integer> leftovers);
}
