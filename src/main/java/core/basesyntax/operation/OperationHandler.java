package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
