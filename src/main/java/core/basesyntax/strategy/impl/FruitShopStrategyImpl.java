package core.basesyntax.strategy.impl;

import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.FruitShopStrategy;
import core.basesyntax.utils.Operation;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FruitShopStrategyImpl implements FruitShopStrategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
