package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionExecutionService;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionExecutionServiceImpl implements TransactionExecutionService {
    @Override
    public void executeTransaction(List<FruitTransaction> transactions,
                                   OperationStrategy operationStrategy) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.handle(transaction);
        }
    }
}
