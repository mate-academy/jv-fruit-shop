package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitShopService;
import service.TransactionStrategy;
import service.activities.TransactionHandler;

public class FruitShopServiceImpl implements FruitShopService {
    private final TransactionStrategy activitiesStrategy;

    public FruitShopServiceImpl(TransactionStrategy activitiesStrategy) {
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public void handleTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            TransactionHandler transactionHandler = activitiesStrategy
                    .getHandler(fruitTransaction.getOperation());
            transactionHandler.executeTransaction(fruitTransaction);
        }
    }
}
