package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String code) {
        return operationHandlerMap.get(code);
    }

    @Override
    public int getCalculatedCount(int count, int quantity, FruitTransaction.Operation operation) {
        return 0;
    }
}
