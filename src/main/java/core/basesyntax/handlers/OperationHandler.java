package core.basesyntax.handlers;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
