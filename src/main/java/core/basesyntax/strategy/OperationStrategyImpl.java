package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.OperationType;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public void performOperation(Transaction transaction) {
        OperationType operationType = OperationType.getByOperationCode(transaction.getOperation());
        operationType.performOperation(transaction);
    }
}
