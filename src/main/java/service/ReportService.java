package service;

import java.util.Map;
import service.impl.Fruit;

public interface ReportService {
    String getReport(Map<Fruit, Integer> report);
}

