package transactionexecutor;

import fruittransaction.FruitTransaction;
import java.util.List;
import strategy.OperationStrategy;

public class TransactionExecutorImpl implements TransactionExecutor {
    private OperationStrategy operationStrategy;
    
    public TransactionExecutorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void execute(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.handle(transaction);
        }
    }
}
