package service.impl;

import db.FruitStorage;
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
    public void putInStorage(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            if (!FruitStorage.fruitStorage.containsKey(transaction.getFruit())) {
                FruitStorage.fruitStorage.put(transaction.getFruit(), transaction.getAmount());
            } else {
                FruitStorage.fruitStorage.put(transaction.getFruit(),
                        activityStrategy.getActivity(transaction.getActivityType())
                                .count(FruitStorage.fruitStorage
                                        .get(transaction.getFruit()), transaction.getAmount()));
            }
        }
    }
}
