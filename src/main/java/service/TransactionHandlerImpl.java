package service;

import java.util.List;
import model.FruitTransaction;
import service.operation.OperationHandler;

public class TransactionHandlerImpl implements TransactionHandlerService {
    private OperationStrategy operationStrategy;

    public TransactionHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transactionHandle(List<FruitTransaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            throw new RuntimeException("Your data is empty!");
        } else {
            for (FruitTransaction fruitTransaction : transactions) {
                OperationHandler operationHandler = operationStrategy.getOperationStrategy(
                        fruitTransaction.getType());
                operationHandler.operation(fruitTransaction);
            }
        }
    }
}
