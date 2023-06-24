package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitService;
import strategy.ActivityStrategy;

public class FruitServiceImpl implements FruitService {
    private final ActivityStrategy activityStrategy;

    public FruitServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void processTransaction(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            activityStrategy.getHandler(transaction.getActivityType()).handle(transaction);
        }
    }
}
