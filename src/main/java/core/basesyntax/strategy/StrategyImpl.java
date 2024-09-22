package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap;

    public StrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
