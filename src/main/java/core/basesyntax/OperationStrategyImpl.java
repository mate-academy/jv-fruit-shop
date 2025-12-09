package core.basesyntax;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;

    }

    @Override // <-- Dodano @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (!operationHandlers.containsKey(operation)) {
            // Użycie .getCode() jest lepsze, jeśli chcesz pokazać oryginalny symbol ('s', 'b', 'p')
            throw new RuntimeException("Unknown operation type: " + operation.getCode());
        }
        return operationHandlers.get(operation);
    }
}
