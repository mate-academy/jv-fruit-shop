package core.basesyntax.service.implementations;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
                                    OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operationType) {
        return operationHandlerMap.get(operationType);
    }
}
