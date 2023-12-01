package dao;

import java.util.Map;

import model.Fruit;

public interface ReportDao {
    Map<String, Integer> getReport();

    void updateReport(Fruit fruit);

    int getBalanceFruit(Fruit fruit);
}
