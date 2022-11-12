package mate.academy.service.impl;

import static mate.academy.db.Storage.fruits;

import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.TransactionService;
import mate.academy.strategy.ActivityStrategy;
import mate.academy.strategy.activities.ActivityHandler;

public class TransactionServiceImpl implements TransactionService {
    private ActivityStrategy activityStrategy;

    public TransactionServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public Map<String, Integer> processedData(
            List<FruitTransaction> fruitTransactionList) {

        for (FruitTransaction fruitTransaction :fruitTransactionList) {
            ActivityHandler activityHandler = activityStrategy.get(fruitTransaction.getOperation());
            activityHandler.handle(fruitTransaction);
        }
        return fruits;
    }
}
