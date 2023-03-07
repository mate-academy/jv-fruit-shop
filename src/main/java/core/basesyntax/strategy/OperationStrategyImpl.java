package core.basesyntax.strategy;

import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.template.FruitTransaction;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationsHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationsHandlerMap) {
        this.operationsHandlerMap = operationsHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operationType) {
        return operationsHandlerMap.get(operationType);
    }
}
