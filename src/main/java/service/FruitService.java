package service;

import java.util.Map;
import model.FruitTransaction;

public interface FruitService {
    void applyTransaction(FruitTransaction transaction);

    Map<String, Integer> getReportData();
}
