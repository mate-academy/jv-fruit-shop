package service;

import java.util.Map;

public interface WriterService {
    void writeReport(Map<String, Integer> reportData, String filePath);
}
