package core.basesyntax.strategy;

import static core.basesyntax.Main.OPERATION_HANDLER_MAP;

import core.basesyntax.model.FruitTransaction;

public class HandlerStrategyImpl implements HandlerStrategy {

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return OPERATION_HANDLER_MAP.get(operation);
    }
}
