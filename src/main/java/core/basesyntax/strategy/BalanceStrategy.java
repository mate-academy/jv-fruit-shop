package core.basesyntax.strategy;

import java.util.function.IntBinaryOperator;

public class BalanceStrategy implements IntBinaryOperator {
    @Override
    public int applyAsInt(int prevValue, int initialValue) {
        return initialValue;
    }
}
