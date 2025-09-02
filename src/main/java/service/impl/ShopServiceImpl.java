package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationStrategy;
import service.ShopService;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        if (transactionList == null) {
            throw new RuntimeException("There are no transactions in the list");
        }
        for (FruitTransaction transaction : transactionList) {
            operationStrategy.get(transaction.getOperation()).apply(transaction);
        }
    }
}
