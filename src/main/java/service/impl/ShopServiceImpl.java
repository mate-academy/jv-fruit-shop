package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import service.operation.OperationHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.performOperation(transaction);
        }
    }
}
