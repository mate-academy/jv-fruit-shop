package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(FruitTransaction transaction, Storage storage) {
        OperationHandler handler = operationHandlers.get(transaction.getOperation());
        if (handler == null) {
            throw new IllegalArgumentException("Unknown operation: " + transaction.getOperation());
        }
        handler.handle(transaction, storage);
    }
}
