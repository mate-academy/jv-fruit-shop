package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler operationHandler(FruitTransaction.Operation operationType) {
        return operationHandlersMap.get(operationType);
    }
}
