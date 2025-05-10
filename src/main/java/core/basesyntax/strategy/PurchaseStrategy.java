package core.basesyntax.strategy;

import java.util.function.IntBinaryOperator;

public class PurchaseStrategy implements IntBinaryOperator {
    @Override
    public int applyAsInt(int prevValue, int purchasedValue) {
        return prevValue - purchasedValue;
    }
}
