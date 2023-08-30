package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import service.operation.OperationTransaction;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void shopTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationTransaction operationTransaction = operationStrategy
                    .getOperation(transaction.getOperation());
            operationTransaction.fruitOperation(transaction);
        }
    }
}
