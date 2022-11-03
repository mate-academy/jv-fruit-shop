package service.impl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import strategy.GeneralOperation;
import strategy.TransactionStrategy;
import strategy.impl.TransactionStrategyImpl;

public class FruitShopServiceImpl implements FruitShopService {
    private final TransactionStrategy transactionStrategy;

    public FruitShopServiceImpl(Map<FruitTransaction.Operation,
            GeneralOperation> operationHandlersMap) {
        this.transactionStrategy = new TransactionStrategyImpl(operationHandlersMap);
    }

    @Override
    public void transfer(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            transactionStrategy.get(transaction.getOperation()).generalOperation(transaction);
        }
    }
}
