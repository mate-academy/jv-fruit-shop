package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operations.DailyOperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, DailyOperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            DailyOperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public DailyOperationHandler get(FruitTransaction.Operation type) {
        return operationHandlerMap.get(type);
    }
}
