package service;

import model.FruitTransaction;
import java.util.Map;

public interface FruitService {
    void applyTransaction(FruitTransaction transaction);
    Map<String, Integer> getReportData();
}
