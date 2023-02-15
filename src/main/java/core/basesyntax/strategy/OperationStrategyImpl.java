package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        return operationMap.get(operation);
    }
}
