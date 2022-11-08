package service.transactionexecutor;

import java.util.List;
import model.FruitTransaction;
import strategy.operationstrategy.OperationStrategy;

public class TransactionExecutorImpl implements TransactionExecutor {
    private OperationStrategy operationStrategy;

    public TransactionExecutorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void executeTransaction(List<FruitTransaction> fruitList) {
        fruitList.forEach(c -> operationStrategy
                .get(c.getOperation())
                .transaction(c));
    }
}
