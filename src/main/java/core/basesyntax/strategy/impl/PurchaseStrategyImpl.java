package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.Strategy;
import java.util.function.IntUnaryOperator;

public class PurchaseStrategyImpl implements Strategy {
    private final IntUnaryOperator operation = value -> -value;

    @Override
    public int calculation(int amount) {
        return operation.applyAsInt(amount);
    }
}
