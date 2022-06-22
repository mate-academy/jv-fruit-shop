package service;

import java.util.List;
import java.util.Map;

public interface CreateReport {
    List<String> createReport(Map<String, Integer> fruitsAtStorageMap);
}
