package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.TransactionHandlerService;
import service.operation.OperationHandler;
import strategy.OperationStrategy;

public class TransactionHandlerImpl implements TransactionHandlerService {
    private OperationStrategy operationStrategy;

    public TransactionHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void handleTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            OperationHandler operationHandler = operationStrategy.getOperationStrategy(
                    fruitTransaction.getType());
            operationHandler.getOperation(fruitTransaction);
        }
    }
}
