package service;

import java.util.Map;
import model.Fruit;

public interface ReportService {
    String createReport(Map<Fruit, Integer> fruitStorage);
}
