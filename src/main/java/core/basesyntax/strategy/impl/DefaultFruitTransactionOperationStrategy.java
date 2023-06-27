package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionOperationHandler;
import core.basesyntax.strategy.FruitTransactionOperationStrategy;
import java.util.Map;

public class DefaultFruitTransactionOperationStrategy
        implements FruitTransactionOperationStrategy {
    private final Map<FruitTransaction.Operation, FruitTransactionOperationHandler> handlerMap;

    public DefaultFruitTransactionOperationStrategy(
            Map<FruitTransaction.Operation, FruitTransactionOperationHandler> handlerMap
    ) {
        this.handlerMap = handlerMap;
    }

    @Override
    public FruitTransactionOperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
