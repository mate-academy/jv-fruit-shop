package core.basesyntax.strategy;

import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.utility.Operation;
import java.util.Map;

public class ShopOperationStrategyImpl implements ShopOperationStrategy {
    private final Map<Operation, ShopOperationHandler> operationHandlerMap;

    public ShopOperationStrategyImpl(Map<Operation, ShopOperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public ShopOperationHandler get(String operationName) {
        return operationHandlerMap.get(Operation.getByValue(operationName));
    }
}
