package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransactionOperation;
import core.basesyntax.service.transaction.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransactionOperation,OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransactionOperation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransactionOperation operation) {
        return operationHandlerMap.get(operation);
    }
}
