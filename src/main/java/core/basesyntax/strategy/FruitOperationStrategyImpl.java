package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransfer;
import core.basesyntax.operationhandler.OperationHandler;
import java.util.Map;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    private Map<FruitTransfer.Operation,OperationHandler> operationHandlerMap;

    public FruitOperationStrategyImpl(Map<FruitTransfer.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransfer.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
