package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.strategyimpl.OperationHandler;
import java.util.Map;

public class TypeStrategyImpl implements TypeStrategy {
    private final Map<FruitRecord.Operation, OperationHandler> operationHandlers;

    public TypeStrategyImpl(Map<FruitRecord.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getType(FruitRecord.Operation operation) {
        return operationHandlers.get(operation);
    }
}
