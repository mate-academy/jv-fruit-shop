package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationStrategyHashMap) {
        this.operationStrategyMap = operationStrategyHashMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationStrategyMap.get(operation);
    }
}
