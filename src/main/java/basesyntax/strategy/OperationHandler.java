package basesyntax.strategy;

import basesyntax.common.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
