package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public void execute(FruitTransaction transaction) {
        OperationHandler handler = operationHandlers.get(transaction.getOperation());
        if (handler != null) {
            handler.handle(transaction);
        } else {
            throw new RuntimeException("Unknown operation: " + transaction.getOperation());
        }
    }
}
