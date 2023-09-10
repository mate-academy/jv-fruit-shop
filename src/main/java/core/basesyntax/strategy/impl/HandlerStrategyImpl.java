package core.basesyntax.strategy.impl;

import static core.basesyntax.Main.OPERATION_HANDLER_MAP;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.OperationHandler;

public class HandlerStrategyImpl implements HandlerStrategy {

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return OPERATION_HANDLER_MAP.get(operation);
    }
}
