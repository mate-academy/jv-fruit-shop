package core.basesyntax.fruitentrytransaction;

import core.basesyntax.fruitentrytransaction.operation.OperationHandler;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OperationStrategy {
    private final Map<FruitEntryTransaction.Operation, OperationHandler> operationHandlersMap;

    public OperationHandler get(FruitEntryTransaction.Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
