package core.basesyntax.strategy.impl;

import java.util.function.ToIntBiFunction;

public class SubtractBiFunction implements ToIntBiFunction<Integer, Integer> {
    @Override
    public int applyAsInt(Integer x, Integer y) {
        return x - y;
    }
}
