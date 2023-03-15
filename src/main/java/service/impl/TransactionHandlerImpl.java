package service.impl;

import handler.OperationHandler;
import java.util.List;
import model.FruitTransaction;
import service.TransactionHandler;
import strategy.OperationStrategy;

public class TransactionHandlerImpl implements TransactionHandler {
    private final OperationStrategy operationStrategy;

    public TransactionHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void parse(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            OperationHandler operationHandler = operationStrategy.get(operation);
            operationHandler.add(transaction);
        }
    }
}
