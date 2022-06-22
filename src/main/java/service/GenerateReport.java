package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface GenerateReport {
    Map<String, Integer> reportMap(List<FruitTransaction> fruitTransactions);

    List<String> createReport(Map<String, Integer> fruitReport);
}
