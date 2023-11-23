package main.dao;

import java.util.Map;

public interface ReportDao {
    Map<String, Integer> get();
    void set(Map<String, Integer> report);
}
