package core.basesyntax;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    // Конструктор приймає нашу карту з Main
    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
