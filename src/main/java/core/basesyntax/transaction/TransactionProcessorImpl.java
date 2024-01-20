package core.basesyntax.transaction;

import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        OperationStrategy operationStrategy = new OperationStrategy();
        for (FruitTransaction transaction : fruitTransactions) {
            operationStrategy.getOperationHandler(transaction.getOperation()).handle(transaction);
        }
    }
}
