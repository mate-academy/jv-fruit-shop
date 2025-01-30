package core.basesyntax.strategy.operation;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
