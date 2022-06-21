package service;

import java.util.List;
import java.util.Map;

public interface ReportGeneratingService {

    List<String> createReport(Map<String, Integer> db);
}
