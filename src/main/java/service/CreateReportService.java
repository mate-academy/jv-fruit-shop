package service;

import model.FruitTransaction;

import java.util.List;

public interface CreateReportService {
    String createReport(List<FruitTransaction> transactions);
}
