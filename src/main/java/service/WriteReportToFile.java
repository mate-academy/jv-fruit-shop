package service;

import java.util.Map;

public interface WriteReportToFile {
    void writeReport(Map<String, Integer> report, String fileName);
}
