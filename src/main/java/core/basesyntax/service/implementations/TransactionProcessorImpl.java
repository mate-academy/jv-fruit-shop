package core.basesyntax.service.implementations;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private OperationStrategy operationStrategy;

    public TransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransaction) {
        for (FruitTransaction transaction : fruitTransaction) {
            OperationHandler operationHandler =
                            operationStrategy.get(transaction.getOperation());
            operationHandler.makeOperation(transaction.getFruit(),
                    transaction.getQuantity());
        }
    }
}
