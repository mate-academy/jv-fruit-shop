package service.impl;

import dao.FruitDao;
import model.FruitTransaction;
import service.ProcessDataService;
import service.operation.OperationHandler;
import strategy.OperationStrategy;

public class ProcessDataServiceImpl implements ProcessDataService {
    private FruitDao dao;
    private OperationStrategy operationStrategy;

    public ProcessDataServiceImpl(FruitDao dao, OperationStrategy operationStrategy) {
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
