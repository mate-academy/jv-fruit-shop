package service;

import java.util.List;
import java.util.Map;

public interface GenerateReportLines {

    List<String> createReport(Map<String, Integer> fruitReport);
}
