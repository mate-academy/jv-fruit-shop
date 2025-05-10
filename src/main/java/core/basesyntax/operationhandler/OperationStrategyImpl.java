package core.basesyntax.operationhandler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlerMap = operationHandlers;
    }

    public Map<FruitTransaction.Operation,
            OperationHandler> getOperationHandlerMap() {
        return operationHandlerMap;
    }

    public void setOperationHandlerMap(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperation(
            FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
