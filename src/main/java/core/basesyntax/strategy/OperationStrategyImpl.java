package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(FruitTransaction transaction) {
        OperationHandler handler = operationHandlers.get(transaction.getOperation());
        if (handler == null) {
            throw new IllegalArgumentException("Unknown operation: " + transaction.getOperation());
        }
        handler.handle(transaction);
    }
}
