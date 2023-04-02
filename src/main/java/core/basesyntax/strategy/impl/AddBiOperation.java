package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.BiOperation;

public class AddBiOperation implements BiOperation {
    @Override
    public int apply(int x, int y) {
        return x + y;
    }
}
