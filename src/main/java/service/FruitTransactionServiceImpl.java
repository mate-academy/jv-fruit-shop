package service;

import java.math.BigDecimal;
import model.Fruit;
import model.FruitTransaction;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private ActivityStrategy activityStrategy;

    public FruitTransactionServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public FruitTransaction createNewTransaction(String transaction) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] fields = transaction.split(",");
        fruitTransaction.setOperation(activityStrategy.getOperation(fields[OPERATION_INDEX]));
        fruitTransaction.setFruit(new Fruit(fields[FRUIT_INDEX]));
        fruitTransaction.setAmount(new BigDecimal(fields[AMOUNT_INDEX]));
        return fruitTransaction;
    }
}
