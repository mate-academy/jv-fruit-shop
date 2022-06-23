package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface GenerateReportLines {
    void createReportMap(List<FruitTransaction> fruitTransactions);

    List<String> createReport(Map<String, Integer> fruitReport);
}
