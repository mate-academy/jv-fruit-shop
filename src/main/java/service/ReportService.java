package service;

import java.util.List;
import model.FruitTransaction;
import strategy.StrategyService;

public interface ReportService {
    String doReport(List<FruitTransaction> transactions, StrategyService strategyService);
}
