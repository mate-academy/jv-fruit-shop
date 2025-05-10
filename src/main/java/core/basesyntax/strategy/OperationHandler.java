package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction input);

    boolean isAplicable(FruitTransaction input);
}
