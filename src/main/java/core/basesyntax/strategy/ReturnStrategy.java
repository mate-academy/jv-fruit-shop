package core.basesyntax.strategy;

import java.util.function.IntBinaryOperator;

public class ReturnStrategy implements IntBinaryOperator {
    @Override
    public int applyAsInt(int prevValue, int returnedValue) {
        return prevValue + returnedValue;
    }
}
