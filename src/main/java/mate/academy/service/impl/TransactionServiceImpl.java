package mate.academy.service.impl;

import static mate.academy.db.Storage.fruits;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.TransactionService;
import mate.academy.strategy.ActivityStrategy;
import mate.academy.strategy.ActivityStrategyImpl;
import mate.academy.strategy.activities.ActivityHandler;
import mate.academy.strategy.activities.AddActivityHandler;
import mate.academy.strategy.activities.SubtractActivityHandler;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public Map<String, Integer> processedData(List<FruitTransaction> fruitTransactionList) {
        Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(FruitTransaction.Operation.BALANCE, new AddActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.SUPPLY, new AddActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.PURCHASE, new SubtractActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.RETURN, new AddActivityHandler());

        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);

        for (FruitTransaction fruitTransaction :fruitTransactionList) {
            ActivityHandler activityHandler = activityStrategy.get(fruitTransaction.getOperation());
            activityHandler.workWithFruits(fruitTransaction);
        }
        return fruits;
    }
}
