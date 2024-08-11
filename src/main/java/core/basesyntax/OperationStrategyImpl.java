package core.basesyntax;

import core.basesyntax.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getOperationHandlers() {
        return operationHandlers;
    }

    public void setOperationHandlers(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

}
