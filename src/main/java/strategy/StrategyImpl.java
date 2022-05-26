package strategy;

import java.util.Map;
import model.FruitTransaction;
import operation.OperationHandler;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler process(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
