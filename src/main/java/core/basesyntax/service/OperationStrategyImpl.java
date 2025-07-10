package core.basesyntax.service;

import core.basesyntax.datemanipulation.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> omap) {
        this.operationHandlerMap = omap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
