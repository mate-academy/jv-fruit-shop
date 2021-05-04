package service;

import java.util.Map;
import model.Fruit;

public interface ReportService {
    void makeStockReportToCsvFile(Map<Fruit, Integer> stock);
}
