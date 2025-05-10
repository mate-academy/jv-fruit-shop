package core.basesyntax.strategy;

import java.util.function.IntBinaryOperator;

public class SupplyStrategy implements IntBinaryOperator {
    @Override
    public int applyAsInt(int prevValue, int suppliedValue) {
        return prevValue + suppliedValue;
    }
}
