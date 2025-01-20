package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return Optional.ofNullable(operationHandlerMap.get(operation))
                .orElseThrow(() -> new RuntimeException(
                        "No operation handler was found for the %s operation".formatted(
                                operation)));
    }
}
