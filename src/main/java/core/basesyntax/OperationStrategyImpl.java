package core.basesyntax;

import java.util.List;
import java.util.Map;

class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                         operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationHandlers.get(transaction.getOperation());
            if (handler != null) {
                handler.apply(transaction);
            } else {
                throw new IllegalArgumentException("No handler for operation: "
                        + transaction.getOperation());
            }
        }
    }
}

