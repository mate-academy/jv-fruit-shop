package service.impl;

import db.Storage;
import java.util.List;
import model.Transaction;
import service.ShopService;
import service.operation.OperationHandler;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.performOperation(transaction);
        }
    }
}
