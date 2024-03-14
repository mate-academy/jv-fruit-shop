package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import java.util.function.IntUnaryOperator;

public class ReturnStrategyImpl implements OperationHandler {
    private final IntUnaryOperator operation = value -> value;

    @Override
    public int calculate(int amount) {
        return operation.applyAsInt(amount);
    }
}
