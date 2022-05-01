package service;

import java.util.List;
import model.FruitTransaction;
import strategy.StrategyService;

public interface ReportService {
    String generateReport(List<FruitTransaction> transactions, StrategyService strategyService);
}
