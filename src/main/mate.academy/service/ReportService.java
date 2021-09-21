package service;

import model.Fruit;
import java.util.Map;

public interface ReportService {
    String createReport(Map<Fruit, Integer> reportMap);
}
