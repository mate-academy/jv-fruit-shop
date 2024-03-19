package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, Operation> operations;

    public OperationStrategyImpl(Map<String, Operation> operations) {
        this.operations = operations;
    }

    public void executeOperation(Transaction transaction) {
        String operationCode = transaction.getOperation().getCode();

        operations.entrySet().stream()
                .filter(entry -> entry.getKey().equals(operationCode))
                .map(Map.Entry::getValue)
                .findFirst()
                .ifPresentOrElse(
                        operation -> operation.execute(transaction),
                        () -> {
                            throw new RuntimeException("Unsupported operation: " + operationCode);
                        });
    }
}
