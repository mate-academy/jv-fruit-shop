package core.basesyntax.service.impl;

import core.basesyntax.handler.DataOperationHandler;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationsStrategy;
import java.util.Map;

public class OperationsStrategyImpl implements OperationsStrategy {
    private Map<Fruit.Operation, DataOperationHandler> operationStrategyMap;

    public OperationsStrategyImpl(Map<Fruit.Operation, DataOperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public DataOperationHandler get(Fruit.Operation operation) {
        return operationStrategyMap.get(operation);
    }
}
