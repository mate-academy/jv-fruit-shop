package service.impl;

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
    public void proccesFruitTransaction(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            operationStrategy.get(transaction.getOperation()).add(transaction);
        }
    }
}
