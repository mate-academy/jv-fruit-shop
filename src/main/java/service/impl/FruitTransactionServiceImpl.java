package service.impl;

import dao.FruitDao;
import model.FruitTransaction;
import service.FruitTransactionService;
import service.operation.OperationHandler;
import strategy.OperationStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitDao dao;
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(FruitDao dao, OperationStrategy operationStrategy) {
        this.dao = dao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(FruitTransaction[] transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler =
                    operationStrategy.getOperationHandler(transaction.getOperation());
            operationHandler.operation(transaction, dao);
        }
    }
}
