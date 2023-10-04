package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.FruitShopStrategy;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FruitShopStrategyImpl implements FruitShopStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
