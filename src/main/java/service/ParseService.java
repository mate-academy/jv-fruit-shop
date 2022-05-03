package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.StrategyService;

public interface ParseService {
    Map<String, Integer> parse(List<FruitTransaction> fruitTransactions,
                               StrategyService strategyService);
}
