package service;

import model.FruitTransaction;

import java.util.List;

public interface ReportService {
    void createReport(List<FruitTransaction> transactions);
}
