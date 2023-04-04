package strategy;

import java.util.Map;
import model.FruitTransaction;

public class FruitStrategyImpl implements FruitStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public FruitStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
