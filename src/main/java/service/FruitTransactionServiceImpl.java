package service;

import java.math.BigDecimal;
import model.Fruit;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private ActivityStrategy activityStrategy;

    public FruitTransactionServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public FruitTransaction createNewTransaction(String type, String fruit, int amount) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(activityStrategy.getOperation(type));
        fruitTransaction.setFruit(new Fruit(fruit));
        fruitTransaction.setAmount(new BigDecimal(amount));
        return fruitTransaction;
    }
}
