package core.basesyntax.strategy;

import core.basesyntax.FruitTransactionImpl;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransactionImpl.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransactionImpl.Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler getHandler(String line) {
        String type = line.split(",")[0];

        for (Map.Entry<FruitTransactionImpl.Operation,
                OperationHandler> entry :operationHandlerMap.entrySet()) {
            if (entry.getKey().getOperation().equals(type)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
