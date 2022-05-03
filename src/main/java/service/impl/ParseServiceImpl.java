package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParseService;
import strategy.StrategyService;

public class ParseServiceImpl implements ParseService {

    @Override
    public Map<String, Integer> parse(List<FruitTransaction> fruitTransactions,
                                      StrategyService strategyService) {
        Map<String, Integer> fruitMap = new HashMap<>();
        for (FruitTransaction transaction : fruitTransactions) {
            int storeQuantity = fruitMap.get(transaction.getFruit()) == null ? 0
                    : fruitMap.get(transaction.getFruit());
            fruitMap.put(transaction.getFruit(),
                    strategyService.get(transaction.getOperation())
                            .operationHandler(transaction, storeQuantity));
        }
        return fruitMap;
    }
}
