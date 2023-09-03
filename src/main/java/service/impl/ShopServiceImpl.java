package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import service.operation.TransactionHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void shopTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            TransactionHandler transactionHandler = operationStrategy
                    .getHandler(transaction.getOperation());
            transactionHandler.handleTransaction(transaction);
        }
    }
}
