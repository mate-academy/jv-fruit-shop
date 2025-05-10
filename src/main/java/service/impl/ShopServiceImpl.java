package service.impl;

import java.util.List;
import java.util.Map;
import model.Transaction;
import service.ShopService;
import service.operation.OperationHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> fruitList;

    public ShopServiceImpl(OperationStrategy operationStrategy, Map<String, Integer> fruitList) {
        this.operationStrategy = operationStrategy;
        this.fruitList = fruitList;
    }

    @Override
    public void process(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.performOperation(transaction);
        }
    }
}
