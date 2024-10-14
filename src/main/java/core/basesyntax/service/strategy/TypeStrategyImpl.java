package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.impl.OperationHandler;
import java.util.Map;

public class TypeStrategyImpl implements TypeStrategy {
    private final Map<FruitRecord.Operation, OperationHandler> operationHandlers;

    public TypeStrategyImpl(Map<FruitRecord.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getHandler(FruitRecord.Operation operation) {
        return operationHandlers.get(operation);
    }
}
