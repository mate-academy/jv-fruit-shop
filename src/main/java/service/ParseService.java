package service;

import java.util.List;
import model.FruitTransaction;
import strategy.StrategyService;

public interface ParseService {
    void parse(List<FruitTransaction> fruitTransactions,
                               StrategyService strategyService);
}
